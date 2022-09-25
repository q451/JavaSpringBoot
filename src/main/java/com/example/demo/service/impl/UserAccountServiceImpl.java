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
}
