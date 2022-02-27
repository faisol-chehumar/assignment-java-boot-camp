package com.sol.demoecom.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "product_variants")
public class ProductVariantModel extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ProductSkuModel productSku;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductAttributeModel productAttribute;
}
