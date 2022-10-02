package com.example.demo.mapper;

import com.example.demo.model.UserInfo;

public interface UserInfoMapper {
    Integer insertOneUserInfo(UserInfo userInfo);

    UserInfo isExistUser(String userid);
}
