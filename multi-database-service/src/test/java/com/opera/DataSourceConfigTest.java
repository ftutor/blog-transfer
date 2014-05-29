package com.opera;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.junit.Ignore;
import org.junit.Test;

import com.opera.core.StockEntity;
import com.opera.core.User;

public class DataSourceConfigTest {
    @Ignore
    @Test
    public void testGetDbForSP() {
        System.out.println(DataSourceConfig.INSTANCE.getDbForSP("SP_Get_User"));
    }

    @Ignore
    @Test
    public void testGetDsByDb() {
        // System.out.println(DataSourceConfig.INSTANCE.getDsByDb(str)("SP_Get_User"));
        String str = "A.username";
        String[] ar = str.split("\\.");
        System.out.println(ar.length);
    }

    @Ignore
    @Test
    public void testGetDsBySp() throws IOException {
        String sp = "SP_Get_User";

        Session session = DataSourceConfig.INSTANCE.getDsBySp(sp);
        Query query = session.createSQLQuery("CALL SP_Get_User()");
        query.setResultTransformer(Transformers.aliasToBean(User.class)

        );
        List<User> result = (List<User>) query.list();
        session.close();
        System.out.println("size: " + result.size());
    }

    @Test
    public void testGetDsBySpForStock() throws IOException {
        String sp = "GetStocks";

        Session session = DataSourceConfig.INSTANCE.getDsBySp(sp);
        Query query = session.createSQLQuery("CALL GetStocks(?)").setParameter(
                0, "ab");
        query.setResultTransformer(Transformers.aliasToBean(StockEntity.class)

        );
        List<StockEntity> result = (List<StockEntity>) query.list();
        session.close();
        System.out.println("size: " + result.size());
    }
}
