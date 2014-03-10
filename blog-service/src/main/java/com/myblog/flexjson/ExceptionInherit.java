package com.myblog.flexjson;

import org.jooq.exception.DataAccessException;
import org.jooq.exception.DataTypeException;

public interface ExceptionInherit {

    void create() throws DataAccessException, DataTypeException;
}
