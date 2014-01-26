package com.myblog.transfer;

import static com.myblog.schema.tables.UserBlog.USER_BLOG;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.schema.tables.records.UserBlogRecord;

@RooJavaBean
@RooToString
@Controller
public class ControllerSimple {

	@Autowired
	private MailSender mailSender;
	@Autowired
	private DataSource dataSource;
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
		Connection conn = DataSourceUtils.getConnection(dataSource);
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		List<UserBlogRecord> result = create.select().from(USER_BLOG)
				.fetchInto(UserBlogRecord.class);
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
