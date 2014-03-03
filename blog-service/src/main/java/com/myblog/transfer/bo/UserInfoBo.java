package com.myblog.transfer.bo;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myblog.BlogFactory;
import com.myblog.schema.tables.records.UserRecord;
import com.myblog.transfer.dao.UserInfoDAO;

@Component
public class UserInfoBo extends BlogFactory {

    private String userName;
    private UserRecord staffInfo;
    @Autowired
    private UserInfoDAO dao;

    @Override
    public void execute(DSLContext dsl) throws Exception {
        // TODO Auto-generated method stub

        staffInfo = dao.getUserByUserName(dsl, userName);
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public UserRecord getStaffInfo() {
        return staffInfo;
    }

}
