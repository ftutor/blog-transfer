package com.opera;

import java.util.List;

import org.springframework.http.HttpHeaders;

import flexjson.JSONSerializer;

public class Utils {

    public static HttpHeaders getJsonHeaders() {
        final HttpHeaders result = new HttpHeaders();
        result.add("Content-Type", "application/json; charset=utf-8");

        return result;
    }

    public static String getJson(List pList) {
        String body = new JSONSerializer().exclude("*.class").serialize(pList);
        return body;
    }
}
