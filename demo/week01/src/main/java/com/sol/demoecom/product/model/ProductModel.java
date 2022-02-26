package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductModel extends BaseModel {
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImageModel> images = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductSkuModel> productSkus;

    @ManyToOne(fetch = FetchType.LAZY)
    private BrandModel brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String productNumber;

    private String description;

    private String shopLocation;

    @Column(nullable = false)
    private int warrantDays = 0;

    public ProductModel() {
    }

    public ProductModel(List<ProductImageModel> images, List<ProductSkuModel> productSkus, BrandModel brand, String name, String productNumber, String description, String shopLocation, int warrantDays) {
        this.images = images;
        this.productSkus = productSkus;
        this.brand = brand;
        this.name = name;
        this.productNumber = productNumber;
        this.description = description;
        this.shopLocation = shopLocation;
        this.warrantDays = warrantDays;
    }

    public ProductModel(String name, String productNumber, String description, String shopLocation, int warrantDays) {
        this.name = name;
        this.productNumber = productNumber;
        this.description = description;
        this.shopLocation = shopLocation;
        this.warrantDays = warrantDays;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "images=" + images +
                ", productSkus=" + productSkus +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", description='" + description + '\'' +
                ", shopLocation='" + shopLocation + '\'' +
                ", warrantDays=" + warrantDays +
                '}';
    }

    public List<ProductImageModel> getImages() {
        return images;
    }

    public void setImages(List<ProductImageModel> images) {
        this.images = images;
    }

    public List<ProductSkuModel> getProductSkus() {
        return productSkus;
    }

    public void setProductSkus(List<ProductSkuModel> productSkus) {
        this.productSkus = productSkus;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
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

    public void addImage(ProductImageModel image) {
        images.add(image);
        image.setProduct(this);
    }
}
