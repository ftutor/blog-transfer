package com.myblog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Version extends ControllerSupport {

    @RequestMapping(value = "/Version.json")
    public ModelAndView getVersion(HttpServletRequest req) throws IOException {

        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("build.properties"));
        Map<String, Object> model = new HashMap<String, Object>();

        Set<Object> sets = prop.keySet();
        for (Object ob : sets) {
            model.put((String) ob, prop.get(ob));
        }
        return new ModelAndView("jsonView", model);

    }
}
