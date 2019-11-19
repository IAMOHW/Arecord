package com.vurlc.arecord.controller;

import com.vurlc.arecord.entity.User;
import com.vurlc.arecord.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = {"用户相关接口"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("查询用户id")
    @GetMapping("/find/id")
    @ResponseBody
    public List<User> selectUserId() {
        return userService.selectUserId();
    }
}
