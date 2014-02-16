package com.myblog.transfer.dao;

import static com.myblog.schema.tables.User.USER;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Component;

import com.myblog.schema.tables.records.UserRecord;

@Component
public class UserInfoDAO {
	private static final Logger logger = Logger.getLogger(UserInfoDAO.class);

	public UserRecord getUserByUserName(DSLContext dsl, String username)
			throws DataAccessException {

		return dsl.selectFrom(USER).where(USER.USER_NAME.equal(username))
				.fetchAny();
	}
}
