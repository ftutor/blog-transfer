package com.myblog.flexjson;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DeserializeOperation {

    public static <T> T DeserializeIncludeMore(T p) {

        JSONSerializer serializer = new JSONSerializer();
        String json = serializer.serialize(p);

        return new JSONDeserializer<T>().deserialize(json);
    }
}
