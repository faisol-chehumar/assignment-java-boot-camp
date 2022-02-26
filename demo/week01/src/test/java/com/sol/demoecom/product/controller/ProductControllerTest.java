package com.sol.demoecom.product.controller;

import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.repository.ProductRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    ProductRepository productRepository;

    @Test
    @DisplayName("Should return true if products size equal to 2 when search with keyword 'nmd'")
    void searchProduct_withKeyword_productSizeEqualToTwo() throws JSONException {
        // Arrange
        List<ProductModel> testProducts = new ArrayList<>();
        ProductModel product1 = new ProductModel("NMD_R1 BOBA FETT SPECTOO SHOES", "234510233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        ProductModel product2 = new ProductModel("NMD_R1 PRIMEBLUE SHOES", "234522233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        testProducts.add(product1);
        testProducts.add(product2);

        String testKeyword = "nmd";
        int assertSize = testProducts.size();

        when(productRepository.findByNameContainsIgnoreCase(testKeyword)).thenReturn(testProducts);
        when(productRepository.count()).thenReturn((long) testProducts.size());

        // Action
        String stringResponse = testRestTemplate.getForObject(String.format("/products/search?keyword=%s", testKeyword), String.class);

        JSONObject jsonResponse = new JSONObject(stringResponse);
        JSONArray productsFromJsonResponse = jsonResponse.getJSONObject("data").getJSONArray("products");

        // Assert
        assertThat(productsFromJsonResponse.length()).isEqualTo(assertSize);
    }

    @Test
    @DisplayName("Should return true if product isNotNull")
    void getProductDetail_withProductId_productNotNull () throws JSONException {
        // Arrange
        ProductModel product = new ProductModel("NMD_R1 BOBA FETT SPECTOO SHOES", "234510233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        product.setId(UUID.fromString("325536ff-cfb8-4ff4-a45c-3483d8717e36"));

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        System.out.println("Action");
        // Action
        String stringResponse = testRestTemplate.getForObject(String.format("/products/%s", product.getId()), String.class);

        JSONObject jsonResponse = new JSONObject(stringResponse);
        JSONObject productFromJsonResponse = jsonResponse.getJSONObject("data");

        // Assert
        assertThat(productFromJsonResponse).isNotNull();
    }
}