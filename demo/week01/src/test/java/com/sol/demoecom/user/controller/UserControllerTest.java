package com.sol.demoecom.user.controller;

import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.product.repository.ProductSkuRepository;
import com.sol.demoecom.user.model.UserBasketItemModel;
import com.sol.demoecom.user.model.UserBasketModel;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    UserRepository userRepository;

    @MockBean
    ProductSkuRepository productSkuRepository;

    @Test
    @DisplayName("Should return credential when login with username: 'user01' and password: 'pass'")
    void login_withCorrectUserAndPass_tokenIsNotEmpty() throws JSONException {
        // Arrange

        String testUsername = "user01";
        String testPassword = "pass";
        UserModel user = new UserModel(testUsername, testPassword);

        when(userRepository.findByUsernameAndPassword(testUsername, testPassword)).thenReturn(Optional.of(user));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject loginJsonObject = new JSONObject();
        loginJsonObject.put("username", testUsername);
        loginJsonObject.put("password", testPassword);
        HttpEntity<String> request =
                new HttpEntity<String>(loginJsonObject.toString(), headers);

        // Action
        String stringResponse = testRestTemplate.postForObject("/user/login", request, String.class);
        JSONObject jsonResponse = new JSONObject(stringResponse);

        String token = jsonResponse.getJSONObject("data").getString("token");

        // Assert
        assertThat(token).isNotEmpty();
    }

    @Test
    @DisplayName("Should return status success when add sku product to basket.")
    void addItemToBasket_withOneProductSku_ResponseStatusSuccess() throws JSONException {
        // Arrange
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


        when(productSkuRepository.findById(productSku.getId())).thenReturn(Optional.of(productSku));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getById(user.getId())).thenReturn(user);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", user.getId().toString());
        JSONObject loginJsonObject = new JSONObject();
        loginJsonObject.put("userId", UserUuid);
        loginJsonObject.put("quantity", 2);
        HttpEntity<String> request =
                new HttpEntity<String>(loginJsonObject.toString(), headers);

        // Action
        String stringResponse = testRestTemplate.postForObject(String.format("/user/basket/%s", productSkuUuid), request, String.class);
        JSONObject jsonResponse = new JSONObject(stringResponse);

        boolean success = jsonResponse.getBoolean("success");

        // Assert
        assertThat(success).isEqualTo(true);
    }

    @Test
    @DisplayName("Should return success true when get item list in basket.")
    void getMyBasket_withOneProductItem_sizeEqualTo1() throws JSONException {
        // Arrange
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

        List<UserBasketItemModel> items = new ArrayList<>();
        UserBasketItemModel userBasketItem = new UserBasketItemModel(user.getUserBasket(), productSku, 2);
        items.add(userBasketItem);
        user.getUserBasket().setItems(items);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getById(user.getId())).thenReturn(user);

        // create headers
        HttpHeaders headers = new HttpHeaders();

        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // example of custom header
        headers.set("token", user.getId().toString());

        // build the request
        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<String> stringResponse = testRestTemplate.exchange(
                String.format("/user/basket?userId=%s", user.getId().toString()),
                HttpMethod.GET,
                request,
                String.class,
                1
        );

        // Action
        JSONObject jsonResponse = new JSONObject(stringResponse.getBody());

        boolean success = jsonResponse.getBoolean("success");

        System.out.println("jsonResponse" + jsonResponse);

        // Assert
        assertThat(success).isEqualTo(true);
    }
}