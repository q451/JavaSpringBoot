package com.example.demo;

import com.example.demo.base.RedisBase;
import com.example.demo.mapper.UserAccountMapper;
import com.example.demo.util.EmailUtil;
import com.example.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.annotation.Resource;

@SpringBootTest
class SpringBootJavaWebApplicationTests {
	//这是redis封装的类
	@Resource
	private RedisUtil redisUtil;
	@Resource
	private JavaMailSender javaMailSender ;

	@Test
	void contextLoads() {
//		redisUtil.get("name");
		SimpleMailMessage message = new SimpleMailMessage() ;	// 要发送的消息内容
		message.setFrom("1393371859@qq.com");
		message.setTo("19301105@bjtu.edu.cn");
		message.setSubject("测试邮件");
		message.setText("好好学习，天天向上");
		this.javaMailSender.send(message);

		EmailUtil email = new EmailUtil();
		System.out.println(1111);
	}

}
