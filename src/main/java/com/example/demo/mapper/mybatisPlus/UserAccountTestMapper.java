package com.example.demo.mapper.mybatisPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.mybatisPlus.UserAccountTest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountTestMapper extends BaseMapper<UserAccountTest> {
    UserAccountTest findByUserid(String userid);
}
