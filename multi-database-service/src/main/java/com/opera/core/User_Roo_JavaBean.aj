// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.opera.core;

import com.opera.core.User;
import java.sql.Timestamp;

privileged aspect User_Roo_JavaBean {
    
    public Integer User.getUserId() {
        return this.userId;
    }
    
    public void User.setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String User.getUserName() {
        return this.userName;
    }
    
    public void User.setUserName(String userName) {
        this.userName = userName;
    }
    
    public String User.getUserPassword() {
        return this.userPassword;
    }
    
    public void User.setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public Timestamp User.getRegistedDate() {
        return this.registedDate;
    }
    
    public void User.setRegistedDate(Timestamp registedDate) {
        this.registedDate = registedDate;
    }
    
    public Timestamp User.getLastLogin() {
        return this.lastLogin;
    }
    
    public void User.setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
    
}