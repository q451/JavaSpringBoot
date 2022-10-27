package com.example.demo.mapper.user;

import com.example.demo.model.user.UserAccount;
import com.example.demo.model.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    //添加一个用户
    List<UserInfo> selectOneUserByUserid(String userid);
}
