package com.example.demo.mapperTest;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
//默认导入包会报错，使用这种方式导入Junit包
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//单元测试
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserAccountMapperTest {
    @Autowired
    UserAccountMapper userAccountMapper;
    @Test
    public void insertOneUser(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserid("20220924");
        userAccount.setPassword("20220824");
        Integer row = userAccountMapper.insertOneUser(userAccount);

        System.out.println(row);
    }
    @Test
    public void findUser(){
        UserAccount userAccount = userAccountMapper.findUser("19301105");
        System.out.println(userAccount);
    }

//    @Test
//    public void selectAllUser(){
//        UserAccount userAccount = userAccountMapper.selectAllUser(1);
//        System.out.println(userAccount);
//    }
}
