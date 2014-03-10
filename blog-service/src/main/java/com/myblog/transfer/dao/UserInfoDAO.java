package com.myblog.transfer.dao;

import static com.myblog.schema.tables.User.USER;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Component;

import com.myblog.schema.tables.records.UserRecord;

@Component
public class UserInfoDAO {
    private static final Logger LOGGER = Logger.getLogger(UserInfoDAO.class);

    public UserRecord getUserByUserName(DSLContext dsl, String username)
            throws DataAccessException {

        return dsl.selectFrom(USER).where(USER.USER_NAME.equal(username))
                .fetchAny();
    }

    public void addNewUser(DSLContext dsl) throws DataAccessException {

        dsl.insertInto(USER)
                .set(USER.USER_ID, 2)
                .set(USER.USER_NAME, "ftutor")
                .set(USER.USER_PASSWORD, "ftutor")
                .set(USER.REGISTED_DATE,
                        new Timestamp(System.currentTimeMillis()))
                .set(USER.LAST_LOGIN, new Timestamp(System.currentTimeMillis()))
                .execute();
        LOGGER.info("ADD NEW USER FINISHED");
        throw new RuntimeException("failed to add new user");

    }
}
