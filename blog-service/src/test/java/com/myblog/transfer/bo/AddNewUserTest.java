package com.myblog.transfer.bo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(TestConstants.contextConfigFile)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext.xml" })
public class AddNewUserTest {

    private static final Logger LOGGER = Logger.getLogger(AddNewUserTest.class);
    @Autowired
    AddNewUser addNew;

    @Test
    public void testExecuteDSLContext() {
        LOGGER.info("testExecuteDSLContext");
        LOGGER.info("result:" + addNew.execute());

        LOGGER.info("testExecuteDSLContext FINISHED");
    }
}
