package com.myblog.transfer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/applicationContext.xml",
        "classpath:/META-INF/spring/BsConfig.xml"
// "file:src/main/webapp/WEB-INF/spring/webmvc-config.xml"
})
@WebAppConfiguration
public class StudentTest {

    @Autowired
    private Student student;

    @Autowired
    private ApplicationContext aC;

    @Autowired
    protected WebApplicationContext wac;

    /*
     * protected MockMvc mockMvc;
     * 
     * @Autowired protected RequestMappingHandlerAdapter handlerAdapter;
     * 
     * @Autowired protected RequestMappingHandlerMapping handlerMapping;
     * 
     * @Autowired protected MockHttpServletRequest request;
     * 
     * @Before public void setUp() { this.mockMvc =
     * webAppContextSetup(this.wac).build();
     * aC.getAutowireCapableBeanFactory().autowireBeanProperties( Student.class,
     * AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true); }
     */

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
