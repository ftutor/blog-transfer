package com.myblog.flexjson;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasicOperationTest {

    private Person person;
    private static final Logger LOG = Logger
            .getLogger(BasicOperationTest.class);

    @Before
    public void initialize() {

        Zipcode zipcode = new Zipcode("240729");
        Phone phone = new Phone("ftutor", "199999");
        Phone phone2 = new Phone("ftutor1", "1888888");
        List<Phone> phones = Arrays.asList(phone, phone2);
        Address address = new Address("ftutor", "westlife", "anq", "canifornio");
        address.setZipcode(zipcode);
        person = new Person("ftutor", new Date(Timestamp.valueOf(
                "1988-11-23 00:00:00").getTime()), "fiction");
        person.setAddresses(Arrays.asList(address));
        person.setPhoneNumbers(phones);
    }

    @Ignore
    @Test
    public void testSerialize() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serialize(person));
    }

    @Ignore
    @Test
    public void testSerializeAnnotation() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serialize(person));
    }

    @Ignore
    @Test
    public void testSerializeInclude() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serializeInclude(person));
    }

    @Ignore
    @Test
    public void testSerializeIncludeMore() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serializeIncludeMore(person));
    }

    @Ignore
    @Test
    public void testSerializeExclude() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serializeExclude(person));
    }

    // @Ignore
    @Test
    public void testSerializeTransformer() {
        LOG.info("Original:" + person.toString());
        LOG.info("output:" + BasicOperation.serializeTransformer(person));
    }

}
