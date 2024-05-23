package com.datehoer.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datehoer.blog.dto.UserLoginDto;
import com.datehoer.blog.dto.UserRegisterDto;
import com.datehoer.blog.entity.User;
import com.datehoer.blog.mapper.UserMapper;
import com.datehoer.blog.service.AuthService;
import com.datehoer.blog.service.UserService;
import com.datehoer.blog.util.MyEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends ServiceImpl<UserMapper, User> implements AuthService {
    @Autowired
    private UserService userService;
    @Override
    public int register(UserRegisterDto userRegisterDto){
        User byUsername = userService.findByUsername(userRegisterDto.getUsername());
        if (byUsername != null){
            User user = new User();
            String salt = MyEncryption.generateSalt();
            user.setSalt(salt);
            user.setUsername(userRegisterDto.getUsername());
            user.setPassword(MyEncryption.hashPassword(userRegisterDto.getPassword(), salt));
            user.setEmail(userRegisterDto.getEmail());
            return 1;
        }else{
            return 0;
        }
    }
    @Override
    public int login(UserLoginDto userLoginDto){
        User byUsername = userService.findByUsername(userLoginDto.getUsername());
        if (byUsername != null){
            User user = baseMapper.selectByUsername(userLoginDto.getUsername());
            if(MyEncryption.verifyPassword(userLoginDto.getPassword(), user.getSalt(), user.getPassword())){
                return 1;
            }
        }
        return 0;
    }
}
