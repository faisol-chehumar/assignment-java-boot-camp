package com.sol.demoecom.user.service;

import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.product.repository.ProductSkuRepository;
import com.sol.demoecom.user.exception.AuthenticationFailException;
import com.sol.demoecom.user.model.UserBasketModel;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserRepository;
import com.sol.demoecom.user.response.UserCredential;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductSkuRepository productSkuRepository;

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
        UserCredential credential = userService.login(username, password);

        // Assert
        assertThat(credential.getToken()).isEqualTo(testCredential);
    }

    @Test
    @DisplayName("Should return true when add product item to basket.")
    void addProductItemToBasket_withInitialData_success() throws AuthenticationFailException {
        // Arrange
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        userService.setProductSkuRepository(productSkuRepository);

        String testUsername = "user01";
        String testPassword = "pass";

        UserModel user = new UserModel(testUsername, testPassword);
        UUID UserUuid = UUID.fromString("8b2b55d0-3269-4bb2-8404-b52ce4e41fef");
        user.setId(UserUuid);
        user.setUserBasket(new UserBasketModel(user));

        ProductModel product = new ProductModel("Adidas R1 Black and Grey FY5727, FZ0077, FY5730 ", "234470233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        product.setId(UUID.fromString("4cad76d1-2bef-4125-83c3-779570dbe65d"));

        ProductSkuModel productSku = new ProductSkuModel("nmd-bl-sm", "sdsd", 1000, 1000, 50, product);
        UUID productSkuUuid = UUID.fromString("4e8b7b81-c66d-435b-a58b-0e7d3e03d7aa");
        productSku.setId(productSkuUuid);
        product.addProductSku(productSku);

        when(userRepository.getById(user.getId())).thenReturn(user);
        when(productSkuRepository.findById(productSku.getId())).thenReturn(Optional.of(productSku));

        // Assert
        boolean result = userService.addProductItemToBasket(user.getId(), productSkuUuid, 2);

        // Assert
        assertThat(result).isTrue();
    }
}
