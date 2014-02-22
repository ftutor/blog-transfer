package com.myblog.transfer.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.ControllerSupport;
import com.myblog.schema.tables.records.UserBlogRecord;
import com.myblog.transfer.bo.AddNewUser;
import com.myblog.transfer.bo.GetBlogItemList;

@Controller
public class ControllerSimple extends ControllerSupport {

    @Autowired
    private MailSender mailSender;
    @Autowired
    private GetBlogItemList blogItem;
    @Autowired
    private AddNewUser addNewUser;
    private static Logger logger = Logger.getLogger(ControllerSimple.class);

    @RequestMapping(value = "/test.json", method = RequestMethod.GET)
    public ModelAndView sendEmail() throws Exception {
        logger.info("start to send email .....");
        String body = " don't disturb me:A to Z System";
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            for (int i = 0; i < 10000; i++) {

                message.setFrom("xxx" + i + "@ddd.com");
                message.setTo("info@atozsystem.org");
                message.setText(body);
                mailSender.send(message);
                logger.info("send times:" + i);
            }
        } catch (Exception e) {
            logger.info("message:" + e.getMessage());
        }

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("animals", new String[] { "Gnu", "Yak", "Bison", "Yeti" });
        logger.info("end to send email .....");
        return new ModelAndView("jsonView", model);

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

    @RequestMapping(value = "/add.json", method = RequestMethod.GET)
    ModelAndView addNewUser() {
        logger.info("start to addNewUser .....");
        addNewUser.execute();

        logger.info("end to addNewUser .....");
        return new ModelAndView("jsonView", null);

    }
}
