package com.sol.demoecom.user.exception;

public class NotEnoughProductException extends RuntimeException {
    public NotEnoughProductException() {
        super("Not enough product.");
    }
}
