package com.opera;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.germinus.easyconf.EasyConf;

public class DataSourceConfig {

    private static final Logger LOG = Logger.getLogger(DataSourceConfig.class);
    private static final String PREFIX = "/META-INF/spring/";
    private static final String DB_CONFIG = "database";
    private static final String TABLE_MAPPING = "sp_db_mapping";

    private Map<String, LocalSessionFactoryBean> dbMap = new HashMap<String, LocalSessionFactoryBean>();
    // new Configuration().configure().buildSessionFactory();

    private Map<String, String> spMap = new HashMap<String, String>();

    public static DataSourceConfig INSTANCE = new DataSourceConfig();

    private DataSourceConfig() {
        loadingSPConfig();
        loadingDBConfig();

    }

    void loadingSPConfig() {

        LOG.info("PATH:" + PREFIX + TABLE_MAPPING);
        Properties prop = EasyConf.getConfiguration(TABLE_MAPPING)
                .getProperties().getProperties();

        for (Object str : prop.keySet()) {
            spMap.put(str.toString(), prop.getProperty(str.toString()));
        }

    }

    public String getDbForSP(String str) {
        String db = spMap.get(str);
        if (str == null || db == null) {
            throw new RuntimeException("can't find db for sp:" + str);
        }

        return db;
    }

    void loadingDBConfig() {

        Properties prop = EasyConf.getConfiguration(DB_CONFIG).getProperties()
                .getProperties();
        Set<String> dbSet = new HashSet<String>();

        for (Object str : prop.keySet()) {
            LOG.info("key:" + str);
            if (str.toString().contains(".")) {
                String dbShortName = str.toString().split("\\.")[0];
                dbSet.add(dbShortName);
            }
        }
        for (String str : dbSet) {
            BasicDataSource ds = new BasicDataSource();
            LOG.info("driverClassName:"
                    + prop.getProperty(str + "." + "driverClassName"));
            LOG.info("url:" + prop.getProperty(str + "." + "url"));
            LOG.info("username:" + prop.getProperty(str + "." + "username"));
            LOG.info("password:" + prop.getProperty(str + "." + "password"));

            ds.setDriverClassName(prop.getProperty(str + "."
                    + "driverClassName"));
            ds.setUrl(prop.getProperty(str + "." + "url"));
            ds.setUsername(prop.getProperty(str + "." + "username"));
            ds.setPassword(prop.getProperty(str + "." + "password"));
            ds.setTestOnBorrow(true);
            ds.setTestOnReturn(true);
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(1800000);
            ds.setNumTestsPerEvictionRun(3);
            ds.setMinEvictableIdleTimeMillis(1800000);
            ds.setValidationQuery("SELECT 1");
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(ds);
            sessionFactory.setPackagesToScan("com.opera");
            Properties params = new Properties();
            params.setProperty("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");
            params.setProperty("hibernate.show_sql", "true");
            sessionFactory.setHibernateProperties(params);

            dbMap.put(str, sessionFactory);
        }

    }

    public LocalSessionFactoryBean getDsByDb(String str) {
        LocalSessionFactoryBean sessionFactory = dbMap.get(str);
        if (str == null || sessionFactory == null) {
            throw new RuntimeException("can't find db for sp:" + str);
        }

        return sessionFactory;
    }

    public Session getDsBySp(String str) throws IOException {
        LOG.info("sp name:" + str);
        String dbName = getDbForSP(str);
        LOG.info("the specified db is : " + dbName);
        LocalSessionFactoryBean fB = getDsByDb(dbName);
        fB.afterPropertiesSet();
        return fB.getObject().openSession();
        // return fB.getObject().getCurrentSession();

    }

}
