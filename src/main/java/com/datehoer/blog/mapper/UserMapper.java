package com.datehoer.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datehoer.blog.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
