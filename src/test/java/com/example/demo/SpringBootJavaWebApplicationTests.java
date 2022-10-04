package com.example.demo;

import com.example.demo.base.RedisBase;
import com.example.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@SpringBootTest
class SpringBootJavaWebApplicationTests {
	//这是redis封装的类
	@Resource
	private RedisUtil redisUtil;
	@Autowired
	private JavaMailSender javaMailSender ;

	@Test
	void contextLoads() {

//		EmailUtil email = new EmailUtil();
//		email.sendSimpleMail("19301105@bjtu.edu.cn","1111","22222");
		//判断邮箱验证码是否正确
//        String email = null;
//        String isCode = null;
//        try {
//            email = (String) session.getAttribute("email");
//            isCode = (String) session.getAttribute("code");
//        } catch (Exception e) {
//            result.put("message","请发送邮箱验证码");
//        }
//        String inputEmail = userAccount.getEmail();
//        String code = userAccount.getCode();
//
//        if (code.equals("")){
//            result.put("message","输入邮箱验证码");
//        }
//        if (!email.equals(inputEmail) && !code.equals(isCode)){
//            result.put("message","邮箱验证码或者邮箱账号输入错误");
//        }
		System.out.println(1111);
	}

}
