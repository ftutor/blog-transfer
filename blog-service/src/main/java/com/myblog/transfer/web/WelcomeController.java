package com.myblog.transfer.web;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.ControllerSupport;

import flexjson.JSONSerializer;

@Controller
public class WelcomeController extends ControllerSupport {

    private static final Logger logger = Logger
            .getLogger(WelcomeController.class);
   // @Autowired
   // private ApplicationContext applicationContext;

    /**
     * This is an example of a controller method that interprets a Mustache
     * template and returns it to the client as HTML.
     */
    @RequestMapping(value = "/welcome.mustache", method = { RequestMethod.GET,
            RequestMethod.POST })
    public ModelAndView get(HttpServletRequest req, Principal principal)
            throws Exception {
        Map<String, Object> model = newModel(req);
        return new ModelAndView("welcome", model);

    }

    /**
     * This is an example of a controller method that generates JSON data.
     */
    @RequestMapping(value = "/animals.json", method = RequestMethod.GET)
    public ModelAndView getAnimals(HttpServletRequest req, Principal principal)
            throws Exception {
        Map<String, Object> model = newModel(req);
        model.put("animals", new String[] { "Gnu", "Yak", "Bison", "Yeti" });
        return new ModelAndView("jsonView", model);
    }

    @RequestMapping(value = "/animals-entity", method = RequestMethod.GET)
    public ResponseEntity<String> getAnimalsEntity(HttpServletRequest req,
            Principal principal) throws Exception {
        List<String> pList = Arrays.asList("Gnu1", "Yak", "Bison", "Yeti");
        String body = new JSONSerializer().exclude("*.class").serialize(pList);
        return new ResponseEntity<String>(body, getJsonHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/animals-entity-1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAnimalsEntityA(HttpServletRequest req,
            Principal principal) throws Exception {
        List<String> pList = Arrays.asList("Gnu1", "Yak", "Bison", "Yeti");

        String body = new JSONSerializer().exclude("*.class").serialize(pList);
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/animals-body", method = RequestMethod.GET)
    @ResponseBody
    public String getAnimalsBody(HttpServletRequest req, Principal principal)
            throws Exception {
        List<String> pList = Arrays.asList("Gnu1", "Yak", "Bison", "Yeti");

        String body = new JSONSerializer().exclude("*.class").serialize(pList);
        return body;
    }

    @RequestMapping(value = "/login.mustache", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest req, Principal principal)
            throws Exception {
        Map<String, Object> model = newModel(req);
        model.put("username", "ftutor");
        model.put("password", "opera");
        logger.info("contend of model:" + model.get("colors"));
        return new ModelAndView("login", model);
    }

    private static HttpHeaders getJsonHeaders() {
        final HttpHeaders result = new HttpHeaders();
        result.add("Content-Type", "application/json; charset=utf-8");

        return result;
    }

}
