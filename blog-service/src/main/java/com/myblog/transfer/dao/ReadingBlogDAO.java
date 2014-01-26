package com.myblog.transfer.dao;

import static com.myblog.schema.tables.UserBlog.USER_BLOG;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import com.myblog.schema.tables.records.UserBlogRecord;

@Component
public class ReadingBlogDAO {
	private static Logger logger = Logger.getLogger(ReadingBlogDAO.class);

	public List<UserBlogRecord> getBlog(DSLContext dsl) {
		List<UserBlogRecord> result = new ArrayList<UserBlogRecord>();
		logger.info("start to execute get Blog");
		result = dsl.selectFrom(USER_BLOG).fetchInto(UserBlogRecord.class);
		logger.info("finish executing get Blog");
		logger.info("size::" + result.size());
		return result;
	}
}
