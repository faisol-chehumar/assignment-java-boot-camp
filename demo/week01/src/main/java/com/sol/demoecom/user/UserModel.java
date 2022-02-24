package com.sol.demoecom.user;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.Entity;

@Entity
public class UserModel extends BaseModel {
    private String username;
    private String password;

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
