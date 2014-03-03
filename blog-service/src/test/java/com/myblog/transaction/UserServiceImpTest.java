package com.myblog.transaction;

import static com.myblog.schema.Tables.USER;
import static org.junit.Assert.assertEquals;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(TestConstants.contextConfigFile)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext.xml" })
public class UserServiceImpTest {
    @Autowired
    BlogService user;
    @Autowired
    DSLContext dsl;

    @Test
    public void testCreate() {
        try {
            try {
                user.create(2, "ftutor", "ftutor");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // Assert.fail();
        } catch (DataAccessException ignore) {
        }

        assertEquals(1, dsl.selectCount().from(USER).fetchAny().getValue(0));
    }

}
