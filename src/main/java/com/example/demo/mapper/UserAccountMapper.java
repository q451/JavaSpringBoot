package com.example.demo.mapper;

import com.example.demo.model.UserAccount;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserAccountMapper {
    Integer insertOneUser(UserAccount userAccount);

    UserAccount findUser(String userid);


}
