package com.example.demo.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailUtil {
    @Resource
    private JavaMailSender javaMailSender;
    @Autowired
    private JavaMailSenderImpl mailSender;     //简单邮件发送

    private final String from = "1393371859@qq.com";
    //只发送文字
    //方法5个参数分别表示：邮件发送者、收件人、抄送人、邮件主题以及邮件内容
    public void sendSimpleMail(String to, String subject, String text) {
        // 简单邮件直接构建一个 SimpleMailMessage 对象进行配置并发送即可
        SimpleMailMessage Msg = new SimpleMailMessage();
        Msg.setFrom(from);
        Msg.setTo(to);
        Msg.setSubject(subject);
        Msg.setText(text);
        try {
            this.javaMailSender.send(Msg);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    //附件或者html邮件
    public void sendComplexMail(String to, String subject, String content, File[] files) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
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
        mailSender.send(mimeMessage);
    }
}
