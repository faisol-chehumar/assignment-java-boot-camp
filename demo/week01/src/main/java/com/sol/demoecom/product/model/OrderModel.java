package com.sol.demoecom.product.model;

import com.sol.demoecom.common.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel extends BaseModel {
    public enum OrderStatus { SUCCESS, PENDING, FAIL }

    @OneToMany(mappedBy = "order")
    private List<ProductRatingModel> productRatings;

    private OrderStatus status;

    public OrderModel() {
    }

    public OrderModel(List<ProductRatingModel> productRatings, OrderStatus status) {
        this.productRatings = productRatings;
        this.status = status;
    }

    public List<ProductRatingModel> getProductRatings() {
        return productRatings;
    }

    public void setProductRatings(List<ProductRatingModel> productRatings) {
        this.productRatings = productRatings;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
