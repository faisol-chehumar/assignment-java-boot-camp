package com.sol.demoecom.order;

import com.sol.demoecom.common.BaseModel;
import com.sol.demoecom.product.model.ProductRatingModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel extends BaseModel {
    public enum OrderStatus { PENDING, PREPARE, DELIVER, SHIPPED }
    public enum ShippingMethod { REGULAR, EMS }
    public enum PaymentChannel { CREDIT_CARD }

    @OneToMany(mappedBy = "order")
    private List<ProductRatingModel> productRatings;

    @OneToMany(mappedBy = "order")
    List<OrderItemModel> orderItems;

    @OneToMany(mappedBy = "order")
    List<OrderTransaction> orderTransaction;

    private String userId;
    private String userAddressId;

    @Column(nullable = false, unique = true)
    private String invoiceNo;

    @Column(nullable = false)
    private ShippingMethod shippingMethod;

    @Column(nullable = false)
    private PaymentChannel paymentChannel;

    @Column(nullable = false)
    private int totalItems;

    @Column(nullable = false)
    private int subTotal;

    @Column(nullable = false)
    private float totalDiscount;

    @Column(nullable = false)
    private int vatPercent;

    @Column(nullable = false)
    private float totalVat;

    @Column(nullable = false)
    private int shippingFee;

    @Column(nullable = false)
    private float netTotal;
    private String remark;

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
