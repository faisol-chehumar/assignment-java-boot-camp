package com.sol.demoecom.user;

import org.h2.engine.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should return true when findByUsernameAndPassword with initial user data.")
    void findByUsernameAndPassword_WithInitialUser_success() {
        // Arrange
        String username = "user02";
        String password = "9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684";

        UserModel user = new UserModel(username, password);
        userRepository.save(user);

        // Act
        Optional<UserModel> matchedUser = userRepository.findByUsernameAndPassword(username, password);

        // Assert
        assertThat(matchedUser).isNotEmpty();
    }
}
