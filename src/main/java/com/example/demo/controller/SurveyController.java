package com.example.demo.controller;

import com.example.demo.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private JavaMailSender javaMailSender;
    @CrossOrigin
    @RequestMapping("get-code")
    public Map<String,Object> getCode(String email, HttpSession session){
        Map<String,Object> result = new HashMap<>();
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
            result.put("code",300);
            result.put("message","邮箱验证码发送失败");
            return result;
        }
        result.put("code",200);
        result.put("message","邮箱验证码发送成功");

        return result;
    }

}
