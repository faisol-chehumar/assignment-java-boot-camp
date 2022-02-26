package com.sol.demoecom.user.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserModel extends BaseModel {
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    UserBasketModel userBasket;

    @Column(nullable=false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    public UserModel() {}

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserBasketModel getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(UserBasketModel userBasket) {
        this.userBasket = userBasket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
