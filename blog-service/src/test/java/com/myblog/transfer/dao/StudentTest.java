package com.myblog.transfer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/applicationContext.xml",
        "classpath:/META-INF/spring/BsConfig.xml" })
@WebAppConfiguration
public class StudentTest {

    @Autowired
    private Student student;
    @Autowired
    private ApplicationContext aC;

    @Test
    public void test() {
        System.out.println("display student: " + student.toString());

    }

    @Test
    public void testApplication() {
        Student student = (Student) aC.getBean("student");
        System.out
                .println("application display student: " + student.toString());

    }
}
