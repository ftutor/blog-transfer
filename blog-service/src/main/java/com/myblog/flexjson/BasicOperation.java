package com.myblog.flexjson;

import java.sql.Date;

import flexjson.JSONSerializer;
import flexjson.transformer.BasicDateTransformer;

public class BasicOperation {

    public static <T> String serialize(T p) {

        JSONSerializer serializer = new JSONSerializer();
        return serializer.serialize(p);
    }

    public static <T> String serializeAnnotation(T p) {

        JSONSerializer serializer = new JSONSerializer();
        return serializer.serialize(p);
    }

    public static <T> String serializeTransformer(T p) {

        JSONSerializer serializer = new JSONSerializer();
        // serializer.transform(new BasicDateTransformer(), "person.birthday");
        serializer.transform(new BasicDateTransformer(), Date.class);
        return serializer.serialize(p);
    }

    public static <T> String serializeInclude(T p) {

        JSONSerializer serializer = new JSONSerializer();
        return serializer.include("phoneNumbers").serialize(p);
    }

    public static <T> String serializeIncludeMore(T p) {

        JSONSerializer serializer = new JSONSerializer();
        return serializer.include("phoneNumbers").include("addresses")
                .rootName("people").serialize(p);

        // return serializer.include("phoneNumbers","addresses")
        // .serialize(p);
    }

    /**
     * <p class=code>
     * exclude("class") not work
     * </p>
     * 
     * @param p
     * @return
     */

    public static <T> String serializeExclude(T p) {

        JSONSerializer serializer = new JSONSerializer();
        return serializer.rootName("people").exclude("*.class").serialize(p);

        // return serializer.include("phoneNumbers","addresses")
        // .serialize(p);
    }
}
