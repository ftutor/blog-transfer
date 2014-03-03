package com.myblog.transfer.bo;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.BlogFactory;
import com.myblog.transfer.dao.UserInfoDAO;

@Component
public class AddNewUser extends BlogFactory {
    private static final Logger LOGGER = Logger.getLogger(AddNewUser.class);

    @Autowired
    private UserInfoDAO dao;

    @Transactional
    @Override
    public void execute(DSLContext dsl) throws Exception {
        LOGGER.info("start to AddNewUser .....");
        for (int i = 0; i < 2; i++) {
            dao.addNewUser(dsl);
        }
        LOGGER.info("end to AddNewUser .....");

    }

}
