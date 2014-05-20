package com.myblog.transfer.messageconverter;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan

public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> httpMessageConverters) {
        httpMessageConverters.add(new BookCaseMessageConverter(new MediaType(
                "text", "csv")));
    }
}
