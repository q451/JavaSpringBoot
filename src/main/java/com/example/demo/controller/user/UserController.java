package com.example.demo.controller.user;

import com.example.demo.model.user.UserAccount;
import com.example.demo.service.user.UserService;
import com.example.demo.util.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/login")
    public Map<String,Object> Login (String userid, String password){
        return userService.login(userid,password);
    }

    @RequestMapping("/register")
    public Map<String,Object> register (UserAccount userAccount, String pwAgain, String code, HttpSession session){
        return userService.register(userAccount,pwAgain,code,session);
    }

    @RequestMapping("/change-password")
    public Map<String,Object> ChangePassword (UserAccount userAccount, String pwAgain, String code, HttpSession session){
        return userService.changePasswoed(userAccount,pwAgain,code,session);
    }
}
