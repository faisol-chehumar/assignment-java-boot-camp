package com.sol.demoecom.user;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModel extends BaseModel {

    @Column(nullable=false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    public UserModel() {

    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
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
