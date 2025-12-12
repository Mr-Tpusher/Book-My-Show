package com.tpusher.bms.controller;

import com.tpusher.bms.dto.request.RegisterUserRequest;
import com.tpusher.bms.dto.request.UserLoginRequest;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.RegisterUserResponse;
import com.tpusher.bms.dto.response.UserLoginResponse;
import com.tpusher.bms.entity.User;
import com.tpusher.bms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    ResponseEntity<GenericBmsResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        logger.trace("/users/register");
        logger.trace("registerUser()");
        logger.debug("registerUserRequest = {}", registerUserRequest);

        // service call
        try {
            User user = userService.registerUser(registerUserRequest);
            logger.info("user successfully created = {}", user);
            RegisterUserResponse response = new RegisterUserResponse(
                    user.getId(),
                    user.getUsername(),
                    user.getUserRole()
            );
            GenericBmsResponse genericBmsResponse = new GenericBmsResponse(
                    "success",
                    "user successfully created",
                    response
            );
            return new ResponseEntity<>(genericBmsResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("user creation failed = {}", e.getMessage());
            return ResponseEntity.badRequest().body(new GenericBmsResponse(
                    "failed",
                    e.getMessage(),
                    null
            ));
        }
    }

    @PostMapping("/login")
    ResponseEntity<GenericBmsResponse> login(@RequestBody UserLoginRequest request) {

        GenericBmsResponse genericBmsResponse;
        try {
            String token = userService.login(request);
            String tokenType = "Bearer";

            UserLoginResponse userLoginResponse = new UserLoginResponse(token, tokenType);
            return ResponseEntity.ok(
                    new GenericBmsResponse(
                            "success",
                            "user login successful",
                            userLoginResponse
                    )
            );
        } catch (Exception e) {
            genericBmsResponse = new GenericBmsResponse(
                    "failed",
                    e.getMessage(),
                    null
            );

            return ResponseEntity.badRequest().body(genericBmsResponse);
        }

    }

}
