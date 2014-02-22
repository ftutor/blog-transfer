package com.myblog.transfer.bo;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myblog.BlogFactory;
import com.myblog.transfer.dao.UserInfoDAO;

@Component
public class AddNewUser extends BlogFactory {

    @Autowired
    private UserInfoDAO dao;

    protected void execute(DSLContext dsl) {
        dao.addNewUser(dsl);
    }

}
