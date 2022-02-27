package com.sol.demoecom.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name="user_addresses")
public class UserAddressesModel extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private UserModel user;

    private String firstname;

    private String lastname;

    @Column(nullable=false)
    private String mobile;

    @Column(nullable=false, unique = true)
    private String email;

    private String address;

    @Column(nullable=false)
    private String district;

    @Column(nullable=false)
    private String province;

    @Column(nullable=false)
    private String zipCode;

    public UserAddressesModel() {
    }

    public UserAddressesModel(UserModel user, String firstname, String lastname, String mobile, String email, String address, String district, String province, String zipCode) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.district = district;
        this.province = province;
        this.zipCode = zipCode;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
