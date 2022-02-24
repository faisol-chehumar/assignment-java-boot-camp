package com.sol.demoecom.user;

import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.user.request.LoginRequest;
import com.sol.demoecom.user.response.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResponseSuccess<UserCredential> login(@RequestBody LoginRequest loginRequest) {
        UserCredential userCredential =  userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return new ResponseSuccess(userCredential);
    }
}
