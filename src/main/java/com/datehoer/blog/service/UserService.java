package com.datehoer.blog.service;

import com.datehoer.blog.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUsername(String username);
}