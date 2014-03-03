package com.myblog.transaction;

import static com.myblog.schema.Tables.USER;

import java.sql.Timestamp;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogServiceImp implements BlogService {

    @Autowired
    DSLContext dsl;

    @Override
    public void create(int id, String userName, String passwd) throws Exception {
        // TODO Auto-generated method stub
        // try {
        for (int i = 0; i < 2; i++)
            dsl.insertInto(USER)
                    .set(USER.USER_ID, id)
                    .set(USER.USER_NAME, userName)
                    .set(USER.USER_PASSWORD, passwd)
                    .set(USER.REGISTED_DATE,
                            new Timestamp(System.currentTimeMillis()))
                    .set(USER.LAST_LOGIN,
                            new Timestamp(System.currentTimeMillis()))
                    .execute();
        // } catch (Exception e) {
        // throw new RuntimeException("fake exception");
        // }
    }

}
