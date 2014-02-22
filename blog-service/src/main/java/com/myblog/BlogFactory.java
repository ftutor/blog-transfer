package com.myblog;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
abstract public class BlogFactory {

    @Autowired
    private DataSource dataSource;

    abstract protected void execute(DSLContext dsl);

    private final static Logger logger = Logger.getLogger(BlogFactory.class);

    @Transactional
    public boolean execute() {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        try {
            execute(create);
            return true;
        } catch (Exception e) {
            logger.error("an error happens during jooq executes", e);
            return false;
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