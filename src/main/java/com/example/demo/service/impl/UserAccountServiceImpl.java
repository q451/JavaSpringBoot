package com.example.demo.service.impl;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import com.example.demo.service.InterfaceUserAccount;
import com.example.demo.service.exception.ServiceException;
import com.example.demo.service.exception.UserIdUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements InterfaceUserAccount {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public void register(UserAccount userAccount) {
        String userid = userAccount.getUserid();
        UserAccount result = userAccountMapper.findUser(userid);
        if (result != null){
            throw new UserIdUsedException("用户已存在");
        }

        Integer raw = userAccountMapper.insertOneUser(userAccount);
        if (raw != 1){
            throw new ServiceException("数据插入失败");
        }
    }

    public void login(UserAccount userAccount) {
        //获取用户输入的密码和账号
        String userid = userAccount.getUserid();
        String password = userAccount.getPassword();
        UserAccount result = userAccountMapper.findUser(userid);

        if (result == null){
            throw new UserIdUsedException("用户不存在，请注册账号");
        }
        //获取用户输入的密码和数据库密码判断
        if (result.getPassword() != password){
            throw new ServiceException("用户输入密码错误");
        }

    }
}
