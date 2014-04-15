package com.myblog.transfer.messageconverter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class BookCaseMessageConverter extends
        AbstractHttpMessageConverter<BookCase> {

    public BookCaseMessageConverter() {
    }

    public BookCaseMessageConverter(MediaType supportedMediaType) {
        super(supportedMediaType);
    }

    public BookCaseMessageConverter(MediaType... supportedMediaTypes) {
        super(supportedMediaTypes);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return BookCase.class.equals(clazz);
    }

    @Override
    public BookCase readInternal(Class<? extends BookCase> clazz,
            HttpInputMessage httpInputMessage) throws IOException,
            HttpMessageNotReadableException {
        CSVReader reader = new CSVReader(new InputStreamReader(
                httpInputMessage.getBody()));
        List<String[]> rows = reader.readAll();
        BookCase bookCase = new BookCase();
        for (String[] row : rows) {
            bookCase.add(new Book(row[0], row[1]));
        }
        return bookCase;
    }

    @Override
    public void writeInternal(BookCase books,
            HttpOutputMessage httpOutputMessage) throws IOException,
            HttpMessageNotWritableException {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(
                httpOutputMessage.getBody()));
        for (Book book : books) {
            writer.writeNext(new String[] { book.getIsbn(), book.getTitle() });
        }
        writer.close();
    }
}
