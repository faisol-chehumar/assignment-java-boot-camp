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

    @Column(unique = true)
    private String address;

    @Column(nullable=false)
    private String district;

    @Column(nullable=false)
    private String province;

    @Column(nullable=false)
    private String zipCode;
}
