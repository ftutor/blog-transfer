package com.myblog.transfer.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/webmvc-config.xml",
        "classpath:/META-INF/spring/applicationContext.xml"
// "classpath:/META-INF/spring/applicationContext-security.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class WelcomeControllerT {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    protected RequestMappingHandlerMapping handlerMapping;

    protected MockMvc mockMvc;

    protected TestUtils testUtils;

    /**
     * Here the environment property for the "env" variable decides if the local
     * webappcontext has to be setup or not. If its not setup it will perform
     * all request against a remote webapplication and otherwise against a
     * locally setup servlet context.
     */
    @Before
    public void setUp() {
        testUtils = new TestUtils();
        this.mockMvc = webAppContextSetup(this.wac).build();
        // applicationContext.getAutowireCapableBeanFactory()
        // .autowireBeanProperties(handlerAdapter,
        // AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);
        // applicationContext.getAutowireCapableBeanFactory()
        // .autowireBeanProperties(handlerMapping,
        // AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);

    }

    @Test
    public void testGetAnimalsEntity() throws Exception {

        String path = "/animals-entity";
        JSONArray result = testUtils.getJSONArray(path, null, HttpStatus.OK,
                handlerAdapter, handlerMapping);

        assertEquals(4, result.length());
    }

}
