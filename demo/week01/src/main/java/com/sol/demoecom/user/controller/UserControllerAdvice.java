package com.sol.demoecom.user.controller;

import com.sol.demoecom.common.UnauthorizationException;
import com.sol.demoecom.common.ResponseFail;
import com.sol.demoecom.product.exception.ProductNotFoundException;
import com.sol.demoecom.user.exception.AuthenticationFailException;
import com.sol.demoecom.user.exception.NotEnoughProductException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(AuthenticationFailException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseFail authenticationFail(AuthenticationFailException e) {
        return new ResponseFail(e.getMessage());
    }

    @ExceptionHandler(NotEnoughProductException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseFail notEnoughProduct(NotEnoughProductException e) {
        return new ResponseFail(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseFail productNotFound(ProductNotFoundException e) {
        return new ResponseFail(e.getMessage());
    }

    @ExceptionHandler(UnauthorizationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseFail notAuthorization(UnauthorizationException e) {
        return new ResponseFail(e.getMessage());
    }
}
