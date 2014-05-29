package com.opera.core;

import java.sql.Timestamp;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class User {

    private Integer userId;
    private String userName;
    private String userPassword;
    private Timestamp registedDate;
    private Timestamp lastLogin;
}
