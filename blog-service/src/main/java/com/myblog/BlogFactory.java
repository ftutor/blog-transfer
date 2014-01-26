package com.myblog;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

@Component
abstract public class BlogFactory {

	@Autowired
	private DataSource dataSource;

	abstract protected void execute(DSLContext dsl);

	public void execute() {
		Connection conn = DataSourceUtils.getConnection(dataSource);
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
		try {
			execute(create);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}