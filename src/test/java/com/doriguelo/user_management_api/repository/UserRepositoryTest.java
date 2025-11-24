package com.doriguelo.user_management_api.repository;

import com.doriguelo.user_management_api.dto.RegisterDTO;
import com.doriguelo.user_management_api.entity.User;
import com.doriguelo.user_management_api.entity.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should get user successfully from DB")
    void findByLoginSuccess() {
        String login = "tiago@test.com";
        RegisterDTO data = new RegisterDTO(login, "123456", UserRole.USER);
        User newUser = new User(data.login(), data.password(), data.role());
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