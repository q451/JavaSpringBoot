package com.example.demo.mapper.user;

import com.example.demo.model.user.UserInfo;
import com.example.demo.model.user.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    //添加一个用户
    List<UserRole> selectOneUserByUserid(String userid);
}
