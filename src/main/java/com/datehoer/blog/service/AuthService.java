package com.datehoer.blog.service;

import com.datehoer.blog.dto.UserLoginDto;
import com.datehoer.blog.dto.UserRegisterDto;
import com.datehoer.blog.entity.User;

public interface AuthService {
    int register(UserRegisterDto userRegisterDto);
    int login(UserLoginDto userLoginDto);
}
