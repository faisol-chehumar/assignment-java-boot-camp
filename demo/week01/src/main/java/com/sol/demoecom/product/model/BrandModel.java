package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandModel extends BaseModel {
    @OneToMany(mappedBy = "brand")
    private List<ProductModel> product;

    @Column(nullable = false, unique = true)
    private String name;

    public BrandModel() {
    }

    public BrandModel(String name) {
        this.name = name;
    }

    public List<ProductModel> getProduct() {
        return product;
    }

    public void setProduct(List<ProductModel> product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
