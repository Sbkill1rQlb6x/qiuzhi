package com.gs.qiuzhi.service;


import com.gs.qiuzhi.pojo.User;
import com.gs.qiuzhi.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll()
    {
        return userMapper.findAll();
    }

}
