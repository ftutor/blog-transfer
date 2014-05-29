package com.opera.core;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opera.DataSourceConfig;
import com.opera.Utils;

@Controller
public class MockController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    ResponseEntity<String> findUser() throws IOException {

        String sp = "SP_Get_User";
        Session session = DataSourceConfig.INSTANCE.getDsBySp(sp);
        Query query = session.createSQLQuery("CALL SP_Get_User()");
        query.setResultTransformer(Transformers.aliasToBean(User.class)

        );
        List<User> result = (List<User>) query.list();
        session.close();
        return new ResponseEntity<String>(Utils.getJson(result),
                Utils.getJsonHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getStock", method = RequestMethod.GET)
    ResponseEntity<String> findStock() throws IOException {

        String sp = "GetStocks";
        Session session = DataSourceConfig.INSTANCE.getDsBySp(sp);
        Query query = session.createSQLQuery("CALL GetStocks(?)").setParameter(
                0, "ab");
        query.setResultTransformer(Transformers.aliasToBean(StockEntity.class)

        );
        List<StockEntity> result = (List<StockEntity>) query.list();
        session.close();
        return new ResponseEntity<String>(Utils.getJson(result),
                Utils.getJsonHeaders(), HttpStatus.OK);
    }
}
