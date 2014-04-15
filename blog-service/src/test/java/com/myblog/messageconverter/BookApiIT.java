package com.myblog.messageconverter;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.myblog.transfer.messageconverter.Book;
import com.myblog.transfer.messageconverter.BookCase;

public class BookApiIT {
    private final static Logger log = Logger.getLogger(BookApiIT.class);
    private final RestTemplate restTemplate = new RestTemplate();

    private final String gettUrl = "http://localhost:8080/blog-service/getbook";
    private final String setUrl = "http://localhost:8080/blog-service/initializebook";

    @Test
    public void testCreateBookWithAuthor() throws Exception {
        restTemplate.put(setUrl, createBook());

        // printLog(sendDate);

    }

    BookCase createBook() {
        BookCase bc = new BookCase();
        Book b = new Book("123", "Spring in Action");
        bc.add(b);
        Book c = new Book("456", "Clean Code");
        bc.add(c);
        return bc;

    }

    void printLog(BookCase bc) {

        for (Book b : bc) {
            log.info(b.toString());
        }
    }

}
