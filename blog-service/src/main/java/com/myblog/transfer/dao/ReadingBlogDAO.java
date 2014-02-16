package com.myblog.transfer.dao;

import static com.myblog.schema.tables.User.USER;
import static com.myblog.schema.tables.UserBlog.USER_BLOG;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
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

	/**
	 * this method aims to check whether a valid user
	 * 
	 * @param dsl
	 *            jooq data access class
	 * @param username
	 *            user input from the form in login screen
	 * @param passwd
	 *            user input from the form in login screen
	 * @return true if he is valid user or not
	 * @throws DataAccessException
	 */
	public boolean loginCheck(DSLContext dsl, String username, String passwd)
			throws DataAccessException {
		List count = dsl.selectFrom(USER).where(USER.USER_NAME.equal(username))
				.and(USER.USER_PASSWORD.equal(passwd)).fetch();
		if (!count.isEmpty()) {
			dsl.update(USER)
					.set(USER.LAST_LOGIN,
							new Timestamp(System.currentTimeMillis()))
					.where(USER.USER_NAME.equal(username))
					.and(USER.USER_PASSWORD.equal(passwd)).execute();
			return true;
		} else {
			return false;
		}

	}
}
