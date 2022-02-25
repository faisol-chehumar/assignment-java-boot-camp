package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_variants")
public class ProductVariantModel extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSkuModel productSku;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductAttributeModel productAttribute;
}
