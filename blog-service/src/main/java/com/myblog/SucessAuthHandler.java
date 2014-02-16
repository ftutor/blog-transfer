package com.myblog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.myblog.schema.tables.records.UserRecord;
import com.myblog.transfer.bo.UserInfoBo;

public class SucessAuthHandler implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private UserInfoBo userInfo;
	private static final Logger logger = Logger
			.getLogger(SucessAuthHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		String uname = principal.getUsername();
		userInfo.setUserName(uname);
		userInfo.execute();
		UserRecord rec = userInfo.getStaffInfo();

		session.setAttribute("username", uname);
		session.setAttribute("password", rec.getUserPassword());
		logger.info("username:" + uname);
		logger.info("password:" + rec.getUserPassword());
		redirectStrategy.sendRedirect(request, response, "/welcome.mustache");

	}

}
