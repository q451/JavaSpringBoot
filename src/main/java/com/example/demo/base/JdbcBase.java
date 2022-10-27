package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcBase {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

}
