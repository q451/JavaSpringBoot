package com.example.demo.service.user;

import com.example.demo.mapper.user.UserAccountMapper;
import com.example.demo.model.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    public List<UserAccount> listUsers(int status){
        return userAccountMapper.selectAll(status);
    }

    public UserAccount findUser(String userid){
        return userAccountMapper.findByUserid(userid);
    }

//    public List<UserAccount> unionUserInfo(){
//        return userAccountMapper.unionSelect();
//    }
}
