package com.myblog.transfer.web;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ContextConfiguration(locations = {
// "file:src/main/webapp/WEB-INF/spring/webmvc-config.xml",
"classpath:/META-INF/spring/applicationContext.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class WelcomeControllerTest {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    protected RequestMappingHandlerMapping handlerMapping;

    protected MockMvc mockMvc;

    @Autowired
    protected MockHttpServletRequest request;

    protected TestUtils testUtils;
    private WelcomeController controller;

    @Before
    public void setUp() {
        testUtils = new TestUtils();
        this.mockMvc = webAppContextSetup(this.wac).build();

        controller = new WelcomeController();
        applicationContext.getAutowireCapableBeanFactory()
                .autowireBeanProperties(controller,
                        AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);
    }

    @Test
    public void testGetAnimalsEntity() throws Exception {

        String path = "/animals-entity";
        // JSONArray result = testUtils.getJSONArray(path, null, HttpStatus.OK,
        // handlerAdapter, handlerMapping);

        final MockHttpServletRequest request;
        request = new MockHttpServletRequest();
        request.setRequestURI(path);

        // Handle the request
        ResponseEntity<String> response = controller.getAnimalsEntity(request,
                null);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.toString());

        // assertEquals(4, result.length());
    }

}
