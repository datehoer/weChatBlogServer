package com.datehoer.blog.controller;

import com.datehoer.blog.entity.User;
import com.datehoer.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.findByUsername(username));
    }
}
