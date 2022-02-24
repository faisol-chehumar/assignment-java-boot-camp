package com.sol.demoecom;

import com.sol.demoecom.user.UserModel;
import com.sol.demoecom.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoEcomApplication {

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	void initializeUserData() {
		UserModel user = new UserModel("user01", "pass");
		userRepository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoEcomApplication.class, args);
	}

}
