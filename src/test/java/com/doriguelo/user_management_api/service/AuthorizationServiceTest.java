package com.doriguelo.user_management_api.service;

import com.doriguelo.user_management_api.entity.User;
import com.doriguelo.user_management_api.entity.UserRole;
import com.doriguelo.user_management_api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class AuthorizationServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    AuthorizationService authorizationService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should load user by username successfully")
    void loadUserByUsernameSuccess() {
        String login = "tiago@test.com";
        User user = new User(login, "password", UserRole.USER);

        when(userRepository.findByLogin(login)).thenReturn(user);

        UserDetails result = authorizationService.loadUserByUsername(login);

        assertNotNull(result);
        assertEquals(login, result.getUsername());
    }
}