package com.sol.demoecom.user.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_baskets")
public class UserBasketModel extends BaseModel {
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToMany(mappedBy = "userBasket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserBasketItemModel> items = new ArrayList<>();

    public UserBasketModel() {
    }

    public UserBasketModel(UserModel user, List<UserBasketItemModel> items) {
        this.user = user;
        this.items = items;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<UserBasketItemModel> getItems() {
        return items;
    }

    public void setItems(List<UserBasketItemModel> items) {
        this.items = items;
    }

    public void addItem(UserBasketItemModel item) {
        items.add(item);
        item.setUserBasket(this);
    }
}
