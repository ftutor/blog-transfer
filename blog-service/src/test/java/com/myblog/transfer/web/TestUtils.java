package com.myblog.transfer.web;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class TestUtils {

    private final static String GET_METHOD = "GET";

    public String getResponseAsString(final String path,
            final Map<String, String> headers,
            final HttpStatus expectedHttpStatus,
            RequestMappingHandlerAdapter handlerAdapter,
            RequestMappingHandlerMapping handlerMapping) {

        MockHttpServletResponse response = new MockHttpServletResponse();

        try {
            URL url = new URL(getFullPath(path));
            System.out.println("getFullPath(path): " + url.getPath() + "?"
                    + url.getQuery());

            MockHttpServletRequest request = new MockHttpServletRequest();
            request.setMethod(GET_METHOD);
            request.setRequestURI(url.getPath());
            if (headers != null) {
                for (String headerParam : headers.keySet()) {
                    request.addHeader(headerParam, headers.get(headerParam));
                }
            }

            if (url.getQuery() != null) {
                List<NameValuePair> nameValuePairs = URLEncodedUtils.parse(
                        url.getQuery(), Charset.defaultCharset());// TODO:
                                                                  // figure out
                                                                  // if this is
                                                                  // correct

                for (NameValuePair nameValuePair : nameValuePairs) {
                    request.addParameter(nameValuePair.getName(),
                            nameValuePair.getValue());
                }
            }
            HandlerExecutionChain handlerExecutionChain = handlerMapping
                    .getHandler(request);

            if (handlerExecutionChain == null) {
                throw new IllegalArgumentException("Request: " + url.getPath()
                        + " could not be mapped to existing controller!");
            }

            Object handler = handlerExecutionChain.getHandler();

            if (handler == null) {
                throw new IllegalArgumentException("Request: " + url.getPath()
                        + " could not be mapped to existing controller!");
            }

            ModelAndView modelAndView = handlerAdapter.handle(request,
                    response, handler);
            String textresponse = response.getContentAsString();

            if (response.getStatus() != expectedHttpStatus.value()) {
                Assert.fail("Expected http status code "
                        + expectedHttpStatus.value() + " does not match "
                        + response.getStatus() + "!");
            }
            return textresponse;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public JSONArray getJSONArray(final String path,
            final Map<String, String> headers,
            final HttpStatus expectedHttpStatus,
            RequestMappingHandlerAdapter handlerAdapter,
            RequestMappingHandlerMapping handlerMapping) {
        final String responseString = getResponseAsString(path, headers,
                expectedHttpStatus, handlerAdapter, handlerMapping);
        JSONArray ret = null;
        try {
            ret = new JSONArray(responseString);
        } catch (JSONException e) {
            Assert.fail("Response not a JSON!");
        }
        return ret;
    }

    protected String getFullPath(final String path) {
        Resource resource = new ClassPathResource("/service.properties");
        String baseURI;
        Integer port;
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            baseURI = props.get("service.scheme") + "://"
                    + props.get("service.host").toString();
            port = Integer.valueOf(props.get("service.port").toString());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        String fullPath = baseURI + ":" + port + path.replace(" ", "%20");
        return fullPath;
    }

    public String concat(final String... args) {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        final StringBuilder result = new StringBuilder();
        for (final String s : args) {
            if (s == null) {
                throw new IllegalArgumentException();
            }
            result.append(s);
        }
        return result.toString();
    }
}
