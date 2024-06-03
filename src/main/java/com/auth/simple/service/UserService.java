package com.auth.simple.service;



import com.auth.simple.action.UserAction;
import com.auth.simple.api.request.UserLoginRequest;
import com.auth.simple.api.request.UserRegisterRequest;
import com.auth.simple.api.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserAction userAction;


    public UserResponse registerUser(UserRegisterRequest userRegisterRequest) {
        var response = new UserResponse();

        if (userAction.exists(userRegisterRequest)) {
            response.setDescription("User already exists");
            return response;
        }

        var user = userAction.convertToUser(userRegisterRequest);
        userAction.register(user);
        response.setDescription("User registered successfully");
        return response;

    }

    public UserResponse loginUser(UserLoginRequest userLoginRequest) {
        var response = new UserResponse();
        if (userAction.login(userLoginRequest)) {
            response.setDescription("User logged in successfully");
        }
        return response;
    }
}
