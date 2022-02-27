package com.sol.demoecom.user.controller;

import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.product.repository.ProductSkuRepository;
import com.sol.demoecom.user.controller.mapper.BasketItemMapper;
import com.sol.demoecom.user.model.UserBasketItemModel;
import com.sol.demoecom.user.model.UserBasketModel;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserBasketRepository;
import com.sol.demoecom.user.repository.UserRepository;
import com.sol.demoecom.user.controller.request.AddItemToBasketRequest;
import com.sol.demoecom.user.controller.request.LoginRequest;
import com.sol.demoecom.user.controller.response.BasketItems;
import com.sol.demoecom.user.controller.response.MyBasket;
import com.sol.demoecom.user.controller.response.UserCredential;
import com.sol.demoecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBasketRepository userBasketRepository;

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

    @GetMapping("/user/basket")
    public ResponseSuccess<MyBasket> getMyBasket(@RequestParam UUID userId) {
        System.out.println("getMyBasketRequest" + userId);
        UserModel user = userRepository.getById(userId);
        UserBasketModel userBasket = user.getUserBasket();
        List<UserBasketItemModel> itemsInBasket = userBasket.getItems();
        List<BasketItems> items = itemsInBasket.stream().map(i -> new BasketItemMapper().mapRow(i)).collect(Collectors.toList());

        return new ResponseSuccess(new MyBasket(userBasket.getItems().size(), items));
    }
}
