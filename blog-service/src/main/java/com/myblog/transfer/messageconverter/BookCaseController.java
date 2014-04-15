package com.myblog.transfer.messageconverter;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BookCaseController {
    private final static Logger log = Logger
            .getLogger(BookCaseController.class);
    private BookCase bookCase;

    @RequestMapping(value = "/getbook", method = RequestMethod.GET)
    @ResponseBody
    public BookCase getBookCase() {
        return this.bookCase;
    }

    @RequestMapping(value = "/initializebook", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void setBookCase(@RequestBody BookCase bookCase) {
        log.info("enter....");
        this.bookCase = bookCase;
        log.info("quit....");

    }

}
