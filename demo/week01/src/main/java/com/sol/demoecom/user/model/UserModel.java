package com.sol.demoecom.user.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserModel extends BaseModel {
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    UserBasketModel userBasket;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddressesModel> addresses = new ArrayList<>();

    @Column(nullable=false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    private String firstname;

    private String lastname;

    private String mobile;

    @Column(unique = true)
    private String email;

    public UserModel() {}

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(String username, String password, String firstname, String lastname, String mobile, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
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

    public List<UserAddressesModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddressesModel> addresses) {
        this.addresses = addresses;
    }
}
