package com.myblog.transfer.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myblog.BlogFactory;
import com.myblog.schema.tables.records.UserBlogRecord;
import com.myblog.transfer.dao.ReadingBlogDAO;

@Component
public class GetBlogItemList extends BlogFactory {
    @Autowired
    private ReadingBlogDAO readBlog;
    private List<UserBlogRecord> allBlog;
    private static Logger logger = Logger.getLogger(GetBlogItemList.class);

    @Override
    public void execute(DSLContext dsl) throws Exception {
        // TODO Auto-generated method stub

        logger.info("start to execute GetBlogItemList....");
        allBlog = readBlog.getBlog(dsl);
        logger.info("end to execute GetBlogItemList....");
        logger.info("all blog number:" + allBlog.size());
    }

    public List<UserBlogRecord> getAllBlog() {
        return allBlog;
    }

}
