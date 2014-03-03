package com.myblog.transaction;

import org.springframework.transaction.annotation.Transactional;

public interface BlogService {
    /**
     * Create a new book.
     * <p>
     * The implementation of this method has a bug, which causes this method to
     * fail and roll back the transaction.
     */
    @Transactional
    void create(int id, String userName, String passwd) throws Exception;
}
