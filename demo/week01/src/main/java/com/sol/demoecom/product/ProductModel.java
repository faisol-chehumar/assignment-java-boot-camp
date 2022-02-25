package com.sol.demoecom.product;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductModel extends BaseModel {
    @OneToMany(mappedBy = "product")
    private List<ProductImageModel> images;

    @OneToMany(mappedBy = "product")
    private List<ProductSkuModel> productSku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int productNumber;

    private String description;

    private String shopLocation;

    @Column(nullable = false)
    private int warrantDays = 0;

    public ProductModel() {
    }

    public ProductModel(List<ProductImageModel> images, List<ProductSkuModel> productSku, String name, int productNumber, String description, String shopLocation, int warrantDays) {
        this.images = images;
        this.productSku = productSku;
        this.name = name;
        this.productNumber = productNumber;
        this.description = description;
        this.shopLocation = shopLocation;
        this.warrantDays = warrantDays;
    }

    public List<ProductImageModel> getImages() {
        return images;
    }

    public void setImages(List<ProductImageModel> images) {
        this.images = images;
    }

    public List<ProductSkuModel> getProductSku() {
        return productSku;
    }

    public void setProductSku(List<ProductSkuModel> productSku) {
        this.productSku = productSku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public int getWarrantDays() {
        return warrantDays;
    }

    public void setWarrantDays(int warrantDays) {
        this.warrantDays = warrantDays;
    }
}
