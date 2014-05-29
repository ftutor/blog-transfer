package com.opera;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Properties p = new Properties();
        InputStream in = PropertiesLoadTest.class
                .getResourceAsStream("sp_db_mapping.properties");
        try {
            p.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(p.getProperty("SP_Get_User"));
        System.out.println(p.getProperty(""));
    }
}
