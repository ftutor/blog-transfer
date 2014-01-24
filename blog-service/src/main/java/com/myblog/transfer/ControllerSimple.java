package com.myblog.transfer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RooJavaBean
@RooToString
@Controller
public class ControllerSimple {
	// Blog blog = null;
	@Autowired
	private MailSender mailSender;
	private static Logger logger = Logger.getLogger(ControllerSimple.class);

	@RequestMapping(value = "/test")
	ModelAndView sendEmail() {
		logger.info("start to send email .....");
		String body = " this is a test";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("yingming.fang@ddd.com");
		message.setTo("csfangym@gmail.com");
		message.setText(body);
		mailSender.send(message);
		logger.info("end to send email .....");

		return null;
	}
}
