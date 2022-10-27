package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.mybatisPlus.UserAccountTestMapper;
import com.example.demo.mapper.user.UserAccountMapper;
import com.example.demo.model.mybatisPlus.UserAccountTest;
import com.example.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;


@SpringBootTest
class SpringBootJavaWebApplicationTests {
	//这是redis封装的类
	@Resource
	private RedisUtil redisUtil;
	@Autowired
	private JavaMailSender javaMailSender ;
	@Autowired
	private UserAccountMapper userAccountMapper;
	@Autowired
	private UserAccountTestMapper userAccountTestMapper;
	@Test
	void contextLoads(){
		IPage<UserAccountTest> page = new Page(1,2);
		QueryWrapper<UserAccountTest> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("status", 1);
		IPage<UserAccountTest> userIPage = userAccountTestMapper.selectPage(page, queryWrapper);
		long total = userIPage.getSize();
		System.out.println("记录数：" + total);
		userIPage.getRecords().forEach(user -> System.out.println(user));
	}

}
