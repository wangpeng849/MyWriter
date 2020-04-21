//package com.wangp.myaop;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class MyaopApplicationTests {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String from;
//
//    @Test
//    public void mailSender() {
//        try {
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setFrom(from);
//            mailMessage.setTo("849183239@qq.com");
//            mailMessage.setSubject("Oauth 重置密码成功");
//            mailMessage.setText("尊敬的 " + " Aix " + "，您好：\n您重置操作的后的密码为：" + "10086" +
//                    "请牢记您的密码或者及时进行修改！");
//            mailSender.send(mailMessage);
//        } catch (Exception e) {
//            System.err.println("邮件发送失败：" + e.getMessage());
//        }
//    }
//
//}
