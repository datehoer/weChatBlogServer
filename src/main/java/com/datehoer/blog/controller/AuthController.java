package com.datehoer.blog.controller;

import com.datehoer.blog.config.PublicResponse;
import com.datehoer.blog.dto.UserLoginDto;
import com.datehoer.blog.dto.UserRegisterDto;
import com.datehoer.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public PublicResponse<String> register(@RequestBody UserRegisterDto userRegisterDto){
        int registerStatus = authService.register(userRegisterDto);
        if (registerStatus == 1){
            return PublicResponse.success(1, "success", "register success");
        }else{
            return PublicResponse.error(0, "failed", "register failed");
        }
    }
    @PostMapping("/login")
    public PublicResponse<String> login(@RequestBody UserLoginDto userLoginDto){
        if (userLoginDto.getUsername() == null || userLoginDto.getPassword() == null){
            return PublicResponse.error("username or password can't use empty");
        }
        int loginStatus = authService.login(userLoginDto);
        if (loginStatus == 1){
            return PublicResponse.success(1, "success", "login success");
        }else{
            return PublicResponse.error(0, "failed", "login failed");
        }
    }
}
