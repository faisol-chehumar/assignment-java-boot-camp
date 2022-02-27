package com.sol.demoecom.user.controller.request;

import java.util.UUID;

public class GetMyBasketRequest {
    private UUID userId;

    public GetMyBasketRequest() {
    }

    public GetMyBasketRequest(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
