package com.example.demo.service.mybatisPlus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.mybatisPlus.UserAccountTestMapper;
import com.example.demo.model.mybatisPlus.UserAccountTest;
import org.springframework.stereotype.Service;

@Service
public class UserAccountTestServiceImpl extends ServiceImpl<UserAccountTestMapper, UserAccountTest> implements UserAccountTestService{

}
