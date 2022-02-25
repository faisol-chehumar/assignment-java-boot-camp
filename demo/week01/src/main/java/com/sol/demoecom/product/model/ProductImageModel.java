package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImageModel extends BaseModel {
    @Column(nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductModel product;

    public ProductImageModel() {
    }

    public ProductImageModel(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
