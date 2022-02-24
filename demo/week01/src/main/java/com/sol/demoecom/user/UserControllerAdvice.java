package com.sol.demoecom.user;

import com.sol.demoecom.common.ResponseFail;
import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.user.response.UserCredential;
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
}
