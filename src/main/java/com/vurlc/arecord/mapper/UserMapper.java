package com.vurlc.arecord.mapper;

import com.vurlc.arecord.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    String TABLE_NAME = "user";

    @Select({"select user.id from",TABLE_NAME})
    List<User> selectUserId();
}
