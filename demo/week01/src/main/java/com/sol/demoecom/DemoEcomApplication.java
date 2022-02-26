package com.sol.demoecom;

import com.sol.demoecom.product.model.ProductModel;
import com.sol.demoecom.product.repository.ProductRepository;
import com.sol.demoecom.user.UserModel;
import com.sol.demoecom.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoEcomApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	void initializeProductData() {
		ProductModel product1 = new ProductModel("Adidas NMD R1 Black and Grey FY5727, FZ0077, FY5730 ", "234510233456", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam imperdiet libero magna, eu volutpat metus euismod sit amet. Nullam aliquet vel orci ac efficitur.", "กรุงเทพ", 365);
		productRepository.save(product1);
	}

	@PostConstruct
	void initializeUserData() {
		UserModel user = new UserModel("user01", "pass");
		userRepository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoEcomApplication.class, args);
	}

}
