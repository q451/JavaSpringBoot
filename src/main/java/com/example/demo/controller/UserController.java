package com.example.demo.controller;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import com.example.demo.service.InterfaceUserAccount;
import com.example.demo.service.exception.ServiceException;
import com.example.demo.service.exception.UserIdUsedException;
import com.example.demo.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Map;
//@Controller +ResponseBody
@RestController
@RequestMapping("/user")

public class UserController{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private  UserAccountMapper userAccountMapper;
    @Autowired
    private InterfaceUserAccount interfaceUserAccount;

    @RequestMapping("/select")
    public List<Map<String,Object>> userList() {
        String sql = "select * from user_account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/find")
    public UserAccount FindUserByUserid(){
        UserAccount userAccount = userAccountMapper.findUser("19301105");
        return userAccount;
    }

    @RequestMapping("/register")
    public JsonResult<Void> register(UserAccount userAccount){
        JsonResult<Void> result = new JsonResult<>();
        try {
            interfaceUserAccount.register(userAccount);
            result.setStatus(200);
            result.setMessage("注册成功");
        } catch (UserIdUsedException e) {
            result.setStatus(4000);
            result.setMessage("用户已存在");
        }catch (ServiceException e) {
            result.setStatus(5000);
            result.setMessage("数据插入异常");
        }

        return result;
    }
}
