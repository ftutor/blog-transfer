package com.myblog.transfer.bo;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myblog.BlogFactory;
import com.myblog.transfer.dao.ReadingBlogDAO;

@Component
public class LoginBo extends BlogFactory {

	private boolean isValidate = false;
	@Autowired
	private ReadingBlogDAO dao;
	private String username;
	private String passwd;

	@Override
	protected void execute(DSLContext dsl) {
		// TODO Auto-generated method stub

		isValidate = dao.loginCheck(dsl, username, passwd);

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isValidate() {
		return isValidate;
	}

}
