package com.sol.demoecom.common;

public class UnauthorizationException extends RuntimeException{
    public UnauthorizationException() {
        super("Invalid token.");
    }
}
