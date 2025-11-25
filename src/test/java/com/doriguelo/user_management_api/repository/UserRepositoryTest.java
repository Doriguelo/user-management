package com.doriguelo.user_management_api.repository;

import com.doriguelo.user_management_api.entity.User;
import com.doriguelo.user_management_api.entity.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driverClassName=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should get user successfully from DB")
    void findByLoginSuccess() {
        String login = "tiago@test.com";
        User newUser = new User(login, "123456", UserRole.USER);
        this.userRepository.save(newUser);

        UserDetails result = this.userRepository.findByLogin(login);

        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo(login);
    }

    @Test
    @DisplayName("Should return null when user not found")
    void findByLoginFailure() {
        String login = "naoexiste@test.com";
        UserDetails result = this.userRepository.findByLogin(login);
        assertThat(result).isNull();
    }
}