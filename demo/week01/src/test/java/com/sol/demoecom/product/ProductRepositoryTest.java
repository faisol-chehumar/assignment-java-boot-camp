package com.sol.demoecom.product;

import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Should return true when findByNameContainsIgnoreCase with 'NMD'. ")
    void findByNameContainsIgnoreCase_WithInitialProduct_success() {
        // Arrange
        ProductModel product1 = new ProductModel("NMD Yeezy", "234510233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        ProductModel product2 = new ProductModel("Adidas NMD", "43981728493", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        productRepository.save(product1);
        productRepository.save(product2);
        // Act
        List<ProductModel> products = productRepository.findByNameContainsIgnoreCase("NMD");

        // Assert
        assertThat(products).hasSize(2);
    }
}
