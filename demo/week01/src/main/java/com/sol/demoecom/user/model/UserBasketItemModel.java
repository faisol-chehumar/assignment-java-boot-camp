package com.sol.demoecom.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;
import com.sol.demoecom.product.model.ProductSkuModel;

import javax.persistence.*;

@Entity
@Table(name="user_basket_items")
public class UserBasketItemModel extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private UserBasketModel userBasket;

    @OneToOne
    @JoinColumn(name = "product_sku_id")
    private ProductSkuModel productSku;

    @Column(nullable = false)
    private int quantity;

    public UserBasketItemModel() {
    }

    public UserBasketItemModel(UserBasketModel userBasket, int quantity, ProductSkuModel productSku) {
        this.userBasket = userBasket;
        this.quantity = quantity;
        this.productSku = productSku;
    }

    public UserBasketModel getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(UserBasketModel userBasket) {
        this.userBasket = userBasket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductSkuModel getProductSku() {
        return productSku;
    }

    public void setProductSku(ProductSkuModel productSku) {
        this.productSku = productSku;
    }
}
