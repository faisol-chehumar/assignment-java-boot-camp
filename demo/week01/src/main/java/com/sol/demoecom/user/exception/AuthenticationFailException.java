package com.sol.demoecom.user.exception;

public class AuthenticationFailException extends RuntimeException {
    public AuthenticationFailException() {
        super("Username or password incorrect");
    }
}
