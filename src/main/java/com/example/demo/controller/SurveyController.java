package com.example.demo.controller;

import com.example.demo.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private JavaMailSender javaMailSender ;

    @RequestMapping("/send")
    public boolean sendEmail(){
//        boolean isScu = email.sendSimpleMail("19301105@bjtu.edu.cn","1111","22222");

        return true;
    }

    @RequestMapping("getCode")
    public boolean getCode(String email,HttpSession session){
        EmailUtil emailUtil = new EmailUtil();
        String code = emailUtil.randomCode();
        //邮箱验证码存储在session里面
        session.setAttribute("email",email);
        session.setAttribute("code",code);

        //发送邮箱验证码
        String subject = "Springboot 验证码";
        String text = "【Springboot】" + code + "（Springboot 注册邮箱验证码，如非本人操作，请忽略！）";
        String from = email;
		SimpleMailMessage message = new SimpleMailMessage() ;	// 要发送的消息内容
		message.setFrom("1393371859@qq.com");
		message.setTo(from);
		message.setSubject(subject);
		message.setText(text);
        try {
            this.javaMailSender.send(message);
        } catch (MailException e) {
            return false;
        }

        return true;
    }

}
