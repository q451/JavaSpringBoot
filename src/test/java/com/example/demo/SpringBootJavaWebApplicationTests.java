package com.example.demo;

import com.example.demo.base.RedisBase;
import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import com.example.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootJavaWebApplicationTests {
	//这是redis封装的类
	@Resource
	private RedisUtil redisUtil;
	@Test
	void contextLoads() {
		redisUtil.set("name","杨小平");

		System.out.println(redisUtil.get("name"));

	}

}
