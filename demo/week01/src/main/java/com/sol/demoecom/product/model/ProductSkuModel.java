package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_skus")
public class ProductSkuModel extends BaseModel {
    @OneToOne(mappedBy = "productSku", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductSkuDiscountModel productSkuDiscount;

    @OneToMany(mappedBy="productSku")
    private List<ProductVariantModel> productVariants;

    @OneToMany(mappedBy="productSku")
    private List<ProductRatingModel> productRatings;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductModel product;

    @Column(nullable = false, unique = true)
    private String sku;

    private String image;

    @Column(nullable = false)
    private int regularPrice;

    private int salePrice;

    @Column(nullable = false)
    private int unitInStock = 0;

    public ProductSkuModel() {
    }

    public ProductSkuModel(ProductSkuDiscountModel productSkuDiscount, List<ProductVariantModel> productVariants, List<ProductRatingModel> productRatings, String sku, String image, int regularPrice, int salePrice, int unitInStock) {
        this.productSkuDiscount = productSkuDiscount;
        this.productVariants = productVariants;
        this.productRatings = productRatings;
        this.sku = sku;
        this.image = image;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.unitInStock = unitInStock;
    }

    public ProductSkuDiscountModel getProductSkuDiscount() {
        return productSkuDiscount;
    }

    public void setProductSkuDiscount(ProductSkuDiscountModel productSkuDiscount) {
        this.productSkuDiscount = productSkuDiscount;
    }

    public List<ProductVariantModel> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariantModel> productVariants) {
        this.productVariants = productVariants;
    }

    public List<ProductRatingModel> getProductRatings() {
        return productRatings;
    }

    public void setProductRatings(List<ProductRatingModel> productRatings) {
        this.productRatings = productRatings;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }
}
