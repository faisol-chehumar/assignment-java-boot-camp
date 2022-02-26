package com.sol.demoecom.product.controller;

import com.sol.demoecom.common.ResponseFail;
import com.sol.demoecom.product.exception.ProductNotFoundException;
import com.sol.demoecom.user.AuthenticationFailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseFail productNotFound(ProductNotFoundException e) {
        return new ResponseFail(e.getMessage());
    }
}
