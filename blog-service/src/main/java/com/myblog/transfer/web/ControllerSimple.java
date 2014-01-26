package com.myblog.transfer.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.schema.tables.records.UserBlogRecord;
import com.myblog.transfer.bo.GetBlogItemList;

@RooJavaBean
@RooToString
@Controller
public class ControllerSimple {

	@Autowired
	private MailSender mailSender;
	@Autowired
	private GetBlogItemList blogItem;
	private static Logger logger = Logger.getLogger(ControllerSimple.class);

	@RequestMapping(value = "/test")
	ModelAndView sendEmail() {
		logger.info("start to send email .....");
		String body = " this is a test";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xxx@ddd.com");
		message.setTo("xxx@gmail.com");
		message.setText(body);
		mailSender.send(message);
		logger.info("end to send email .....");
		return null;

	}

	@RequestMapping(value = "/db")
	ModelAndView testDb() {
		logger.info("start to testDb .....");
		blogItem.execute();
		List<UserBlogRecord> result = blogItem.getAllBlog();
		int i = 0;
		for (UserBlogRecord ins : result) {
			logger.info("item:" + i + " :" + ins.toString());
		}
		logger.info("end to testDb .....");
		return null;

	}

	public static void main(String[] args) {
		logger.info("test.log");

	}
}
