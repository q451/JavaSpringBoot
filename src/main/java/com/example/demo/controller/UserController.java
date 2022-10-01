package com.example.demo.controller;

import com.example.demo.base.RedisBase;
import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserAccount;
import com.example.demo.model.UserInfo;
import com.example.demo.service.InterfaceUserAccount;
import com.example.demo.service.exception.ServiceException;
import com.example.demo.service.exception.UserIdUsedException;
import com.example.demo.util.JsonResult;
import com.example.demo.util.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.rowset.serial.SerialException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    private UserInfoMapper userInfoMapper;

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
    public Map<String,Object> register(UserAccount userAccount){
        Map<String,Object> result = new HashMap<>();

        //判断数据是否在userinfo表里面
        UserInfo userInfo = userInfoMapper.isExistUser(userAccount.getUserid());
        if (userInfo != null){
            result.put("message","用户已存在");
        }else{
            try {
                //存到user info表里面
                UserInfo users = new UserInfo();
                users.setUserid(userAccount.getUserid());
                users.setName(userAccount.getUserid());
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                users.setCreate_time(dateFormat.format(date));
                userInfoMapper.insertOneUserInfo(users);
                //存到user account表里面
                interfaceUserAccount.register(userAccount);
                //返回数据
                result.put("message","注册成功");
                result.put("code",200);
                result.put("data",users);
            } catch (Exception e) {
                result.put("message","注册失败");
            }
        }

        return result;
    }

    @RequestMapping("/login")
    public Map<String,Object> login (UserAccount userAccount){
        //创建返回类型
        Map<String,Object> result = new HashMap<>();

        String userid = userAccount.getUserid();
        String password = userAccount.getPassword();

        //获取数据库存储的密码
        UserAccount userInfo = userAccountMapper.findUser(userid);
        String userPassword = userInfo.getPassword();

        //判断密码
        if(userInfo == null){
            result.put("message","用户不存在");
            result.put("code",400);
        }else if(password.equals(userPassword)){
            String token = TokenUtil.generateToken(userInfo);
            result.put("message","登陆成功");
            result.put("code",200);
            result.put("data",userInfo);
            result.put("token",token);
        }else{
            result.put("message","用户密码输入错误");
            result.put("code",300);
        }
        return result;
    }

    @RequestMapping("/test")
    public JsonResult<UserAccount> test(UserAccount userAccount){

        String userid = userAccount.getUserid();
        String password = userAccount.getPassword();

        UserAccount userInfo = userAccountMapper.findUser(userid);
        String userPassword = userInfo.getPassword();

        JsonResult<UserAccount> result = new JsonResult<>();

        result.setStatus(200);
        result.setMessage("数据返1回格式测试");
        result.setData(userInfo);

        if (password != userPassword){
            result.setMessage(password+"nihao"+ userPassword);
        }

        return result;
    }
}
