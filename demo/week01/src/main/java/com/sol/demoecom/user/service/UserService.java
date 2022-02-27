package com.sol.demoecom.user.service;

import com.sol.demoecom.product.exception.ProductNotFoundException;
import com.sol.demoecom.product.model.ProductSkuModel;
import com.sol.demoecom.product.repository.ProductSkuRepository;
import com.sol.demoecom.user.exception.AuthenticationFailException;
import com.sol.demoecom.user.exception.NotEnoughProductException;
import com.sol.demoecom.user.model.UserBasketItemModel;
import com.sol.demoecom.user.model.UserBasketModel;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserRepository;
import com.sol.demoecom.user.controller.response.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductSkuRepository productSkuRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setProductSkuRepository(ProductSkuRepository productSkuRepository) {
        this.productSkuRepository = productSkuRepository;
    }

    public UserCredential login(String username, String password) {
        Optional<UserModel> matchedUser = userRepository.findByUsernameAndPassword(username, password);
        if(matchedUser.isPresent()) {
            return new UserCredential(matchedUser.get().getId().toString());
        }

        throw new AuthenticationFailException();
    }

    public boolean addProductItemToBasket(UUID userId, UUID productSkuId, int itemQuantity) {
        UserModel user = userRepository.getById(userId);

        UserBasketModel userBasket = user.getUserBasket();
        Optional<ProductSkuModel> productSku = productSkuRepository.findById(productSkuId);

        if(productSku.isPresent()) {
            if(productSku.get().getUnitInStock() <= 0 || productSku.get().getUnitInStock() < itemQuantity) {
                throw new NotEnoughProductException();
            }
            UserBasketItemModel itemInBasket = new UserBasketItemModel(userBasket, productSku.get(), itemQuantity);
            userBasket.addItem(itemInBasket);
            userRepository.save(user);
            return true;
        }

        throw new ProductNotFoundException();
    }
}
