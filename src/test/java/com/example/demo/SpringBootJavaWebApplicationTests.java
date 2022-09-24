package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SpringBootJavaWebApplicationTests {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
		String sql = "SELECT count(*) FROM user_account";
		Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(integer);
	}

}
