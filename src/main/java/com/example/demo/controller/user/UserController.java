package com.example.demo.controller.user;

import com.example.demo.model.user.UserAccount;
import com.example.demo.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/list-users")
    public List<UserAccount> ListUsers (int status){
        return userService.listUsers(status);
    }

    @RequestMapping(value = "/user-account",method = RequestMethod.POST)
    public UserAccount UserAccountInfo (String userid){
        return userService.findUser(userid);
    }

//    @RequestMapping("/union_user")
//    public List<UserAccount> UnionUsers (){
//        return userService.unionUserInfo();
//    }
}
