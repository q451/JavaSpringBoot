package com.example.demo.controller;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private  UserAccountMapper userAccountMapper;
    @RequestMapping("/select")
    public List<Map<String,Object>> userList() {
        String sql = "select * from user_account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/add")
    public String addUser() {
        String sql = "insert into user_account(userid, password) values('19301106','19301106')";
        jdbcTemplate.update(sql);
        return "添加数据成功";
    }
    @RequestMapping("/update/{userid}")
    public String updateUser(@PathVariable("userid") String userid) {
        String sql = "update user_account set userid  = ?,password = ? where userid = " + userid;
        //封装
        Object[] objects = new Object[2];

        objects[0] = "20220924";
        objects[1] = "20220924";

        jdbcTemplate.update(sql,objects);
        return "数据修改成功";
    }

    @RequestMapping("/delete/{userid}")
    public String deleteUser(@PathVariable("userid") int userid) {
        String sql = "delete from user_account where userid = ?";
        jdbcTemplate.update(sql,userid);
        return "账户删除成功";
    }

    @RequestMapping("/find")
    public UserAccount FindUserByUserid(){
        UserAccount userAccount = userAccountMapper.findUser("19301105");
        return userAccount;

    }

}
