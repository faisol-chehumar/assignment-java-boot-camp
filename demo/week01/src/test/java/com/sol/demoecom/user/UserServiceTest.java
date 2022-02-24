package com.sol.demoecom.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should return accessToken when login with correct username and password")
    void login_withInitialData_success() throws AuthenticationFailException {
        // Arrange
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);

        String username = "user01";
        String password = "pass";
        String testCredential = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IlVzZXIwMSJ9.saNh8MedJAAeSWE06XH5M-2EcWny0ZFfvIS-qJjFfWk";

        UserModel user = new UserModel(username, password);
        when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(user));

        // Assert
        String credential = userService.login(username, password);

        // Assert
        assertThat(credential).isEqualTo(testCredential);
    }
}
