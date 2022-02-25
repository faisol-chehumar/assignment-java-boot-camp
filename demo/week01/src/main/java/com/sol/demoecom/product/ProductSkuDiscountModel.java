package com.sol.demoecom.product;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_sku_discounts")
public class ProductSkuDiscountModel extends BaseModel {
    public enum DiscountTypeEnums { FIXED, PERCENT }

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_sku_id")
    private ProductSkuModel productSku;

    @Column(nullable = false)
    private DiscountTypeEnums type;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false)
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public ProductSkuDiscountModel() {
    }

    public ProductSkuDiscountModel(ProductSkuModel productSku, DiscountTypeEnums type, int value, LocalDateTime startDate, LocalDateTime endDate) {
        this.productSku = productSku;
        this.type = type;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProductSkuModel getProductSku() {
        return productSku;
    }

    public void setProductSku(ProductSkuModel productSku) {
        this.productSku = productSku;
    }

    public DiscountTypeEnums getType() {
        return type;
    }

    public void setType(DiscountTypeEnums type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
