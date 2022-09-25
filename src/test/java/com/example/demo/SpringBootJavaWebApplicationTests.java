package com.example.demo;

import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SpringBootJavaWebApplicationTests {
	@Autowired
	JdbcTemplate jdbcTemplate;
//	@Autowired
//	UserAccountMapper userAccountMapper;
	@Test
	void contextLoads() {
		String sql = "SELECT count(*) FROM user_account";
		Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(integer);
//		UserAccount userAccount = new UserAccount();
//		userAccount.setUserid("20220924");
//		userAccount.setPassword("20220824");
//		Integer row = userAccountMapper.insertOneUser(userAccount);
//
//		System.out.println(row);
	}

}
