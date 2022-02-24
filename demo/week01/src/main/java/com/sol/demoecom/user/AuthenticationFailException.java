package com.sol.demoecom.user;

public class AuthenticationFailException extends RuntimeException {
    public AuthenticationFailException() {
        super("Username or password incorrect");
    }
}
