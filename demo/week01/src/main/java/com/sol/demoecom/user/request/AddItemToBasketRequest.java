package com.sol.demoecom.user.request;

import java.util.UUID;

public class AddItemToBasketRequest {
    private UUID userId;
    private int quantity;

    public AddItemToBasketRequest(UUID userId, int quantity) {
        this.userId = userId;
        this.quantity = quantity;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
