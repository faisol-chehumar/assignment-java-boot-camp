package com.sol.demoecom.user;

import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.product.repository.ProductSkuRepository;
import com.sol.demoecom.user.model.UserBasketItemModel;
import com.sol.demoecom.user.model.UserBasketModel;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserRepository;
import com.sol.demoecom.user.request.AddItemToBasketRequest;
import com.sol.demoecom.user.request.LoginRequest;
import com.sol.demoecom.user.response.UserCredential;
import com.sol.demoecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @PostMapping("/user/login")
    public ResponseSuccess<UserCredential> login(@RequestBody LoginRequest loginRequest) {
        UserCredential userCredential =  userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return new ResponseSuccess(userCredential);
    }

    @PostMapping("/user/basket/{productSkuId}")
    public ResponseSuccess addItemToBasket(@PathVariable UUID productSkuId, @RequestBody AddItemToBasketRequest addItemToBasketRequest) {
        int itemQuantity = addItemToBasketRequest.getQuantity();
        UUID userId = addItemToBasketRequest.getUserId();

        userService.addProductItemToBasket(userId, productSkuId, itemQuantity);

        return new ResponseSuccess(null);

    }
}
