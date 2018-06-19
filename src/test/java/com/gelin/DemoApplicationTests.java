package com.gelin;

import com.gelin.domain.Gl;
import com.gelin.email.MailUtils;
import com.gelin.mangodb.GlDao;
import com.gelin.util.UUIDutils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private GlDao glDao;

    @Test
    public void test1() throws MessagingException {
        MailUtils.sendMail("302966057@qq.com", UUIDutils.getUUID());
//		SendEmail sendEmail=new SendEmail();
//		sendEmail.sendMessage("962422150@qq.com",5);
    }


    @Test
    public void test2() {
        Gl gl = new Gl();
        gl.setId(1);
        gl.setName("豆腐干豆腐个");
        gl.setAge(24);
        glDao.save(gl);
    }


}
