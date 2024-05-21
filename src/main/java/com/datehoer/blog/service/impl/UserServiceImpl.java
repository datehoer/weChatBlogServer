package com.datehoer.blog.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datehoer.blog.entity.User;
import com.datehoer.blog.mapper.UserMapper;
import com.datehoer.blog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User findByUsername(String username){
        User user = baseMapper.selectByUsername(username);
        if (user == null){
            throw new RuntimeException("username not found");
        }
        return user;
    }
}
