package com.vurlc.arecord.service;

import com.vurlc.arecord.entity.User;
import com.vurlc.arecord.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUserId(){
        return userMapper.selectUserId();
    }
}
