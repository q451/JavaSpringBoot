package com.example.demo.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Random;

public class EmailUtil {
    @Autowired
    public JavaMailSender javaMailSender;
    private final String from = "1393371859@qq.com";

    //只发送文字
    //方法5个参数分别表示：邮件发送者、收件人、抄送人、邮件主题以及邮件内容
    public boolean sendSimpleMail(String to, String subject, String text) {
        // 简单邮件直接构建一个 SimpleMailMessage 对象进行配置并发送即可
        try {
            SimpleMailMessage Msg = new SimpleMailMessage();
            Msg.setFrom(from);
            Msg.setTo(to);
            Msg.setSubject(subject);
            Msg.setText(text);
            javaMailSender.send(Msg);
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //附件或者html邮件
    public boolean sendComplexMail(String to, String subject, String content, File[] files) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(from); // 设置发送发
        helper.setTo(to); // 设置接收方
        helper.setSubject(subject); // 设置邮件主题
        helper.setText(content); // 设置邮件内容
        if (files != null && files.length > 0) { // 添加附件（多个）
            for (File file : files) {
                helper.addAttachment(file.getName(), file);
            }
        }
        // 发送邮件
        javaMailSender.send(mimeMessage);

        return true;
    }

    /**
     * 随机生成6位数的验证码
     * @return String code
     */
    public String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public String test(String email, HttpSession session){
        //将随机数放置到session中
        String code = randomCode();
        session.setAttribute("email",email);
        session.setAttribute("code",code);

        //获取session中的验证信息

        return code;

    }
}
