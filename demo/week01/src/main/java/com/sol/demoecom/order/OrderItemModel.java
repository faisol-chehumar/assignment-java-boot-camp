package com.sol.demoecom.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;
import com.sol.demoecom.product.model.ProductSkuModel;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemModel extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private OrderModel order;

    @OneToOne
    @JoinColumn(name = "product_sku_id")
    private ProductSkuModel productSku;

    @Column(nullable = false)
    private int quantity;
}
