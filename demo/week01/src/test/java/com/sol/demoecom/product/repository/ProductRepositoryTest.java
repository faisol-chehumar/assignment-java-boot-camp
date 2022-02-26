package com.sol.demoecom.product.repository;

import com.sol.demoecom.product.model.BrandModel;
import com.sol.demoecom.product.model.ProductImageModel;
import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Test
    @DisplayName("Should return true if product size is 2 when input is 'Nike'.")
    void findByNameContainsIgnoreCase_withInitialProduct_productSizeEqual2() {
        // Arrange
        ProductModel product1 = new ProductModel("Nike Yeezy", "234510253456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        ProductModel product2 = new ProductModel("Adidas Nike", "43181728493", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
        productRepository.save(product1);
        productRepository.save(product2);
        // Act
        List<ProductModel> products = productRepository.findByNameContainsIgnoreCase("Nike");

        // Assert
        assertThat(products).hasSize(2);
    }

    @Test
    @DisplayName("Should return product isNotNull when get with saved productId.")
    void findById_withInitialProduct_resultIsNotEmpty() {
        // Arrange
        ProductModel product = new ProductModel("SUPERSTAR SHOES", "234510253456", "For over 50 years, the adidas Superstar sneaker has been the go-to of sport and street legends, connecting creators across cultures.", "กรุงเทพ", 365);
        product = productRepository.save(product);

        // Act
        Optional<ProductModel> products = productRepository.findById(product.getId());

        // Assert
        assertThat(products).isNotEmpty();
    }
}
