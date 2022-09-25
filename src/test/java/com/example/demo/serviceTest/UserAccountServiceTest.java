package com.example.demo.serviceTest;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import com.example.demo.service.InterfaceUserAccount;
import com.example.demo.service.impl.UserAccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//单元测试
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserAccountServiceTest {
    @Autowired
    InterfaceUserAccount userAccountService;
    @Test
    public void register(){
        try {
            UserAccount userAccount = new UserAccount();
            userAccount.setUserid("123456");
            userAccount.setPassword("123456");
            userAccountService.register(userAccount);

            System.out.println("测试成功");
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

}
