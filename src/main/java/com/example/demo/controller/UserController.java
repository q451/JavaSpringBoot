package com.example.demo.controller;

import model.UserAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserAccountService;

@RestController
@RequestMapping("/user")
public class UserController{
    @RequestMapping("/login")

    public String Login(){
        return "login in";
    }

    @RequestMapping("/add")
    public String addAccount() {
        UserAccount accountInsert = new UserAccount();
        accountInsert.setStatus(1);
        accountInsert.setUserid("19301105");
        accountInsert.setPassword("55684518");

        UserAccountService accountService = new UserAccountService();
        accountService.addUserAccount(accountInsert);

        return "数据插入成功";
    }

}
