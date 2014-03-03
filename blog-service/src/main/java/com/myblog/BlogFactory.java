package com.myblog;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
abstract public class BlogFactory {

    @Autowired
    private DataSource dataSource;
    @Autowired
    DefaultDSLContext create;

    abstract public void execute(DSLContext dsl) throws Exception;

    private final static Logger logger = Logger.getLogger(BlogFactory.class);

    // @Transactional
    public boolean execute() {
        // Connection conn = DataSourceUtils.getConnection(dataSource);
        // DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        try {
            execute(create);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("an error happens during jooq executes",
                    e);

        } finally {
            // create
            // if (conn != null) {
            // try {
            // conn.close();
            // } catch (SQLException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }
            // }
        }
        // return false;
    }
}