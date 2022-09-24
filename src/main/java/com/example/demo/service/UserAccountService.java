package com.example.demo.service;

import com.example.demo.dao.UserAccountDao;
import com.example.demo.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserAccountService implements UserAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

}
