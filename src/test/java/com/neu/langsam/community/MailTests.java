package com.neu.langsam.community;


import com.neu.langsam.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.senMail("1844678540@qq.com","你是一个大帅哥","你好帅");
    }


    @Test
    public void testHtmlMail(){
        Context context=new Context();
        context.setVariable("username","langsam");
        String content=templateEngine.process("/mail/demo",context);
        mailClient.senMail("1844678540@qq.com","欢迎",content);
    }
}
