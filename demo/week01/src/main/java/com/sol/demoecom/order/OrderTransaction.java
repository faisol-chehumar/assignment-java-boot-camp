package com.sol.demoecom.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sol.demoecom.common.BaseModel;
import com.sol.demoecom.user.model.UserModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_transactions")
public class OrderTransaction extends BaseModel {
    public enum OrderTransactionStatus { PENDING, FAIL, SUCCESS }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private OrderModel order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private UserModel user;

    @Column(nullable = false)
    private String refNumber;

    @Column(nullable = false)
    private OrderTransactionStatus status;

    @Column(nullable = false)
    private LocalDateTime expired_date;

    public OrderTransaction() {
    }

    public OrderTransaction(OrderModel order, UserModel user, String refNumber, OrderTransactionStatus status, LocalDateTime expired_date) {
        this.order = order;
        this.user = user;
        this.refNumber = refNumber;
        this.status = status;
        this.expired_date = expired_date;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public OrderTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(OrderTransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(LocalDateTime expired_date) {
        this.expired_date = expired_date;
    }
}
