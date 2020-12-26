package com.ex.webapp.DAO;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * This abstract idea follows the same idea as our abstract application in project 0 by
 * allowing us to set a connection with our database
 */
public abstract class AbstractDAO {

    protected static SessionFactory sessionFactory;

    protected static void configure() {
        Configuration config  = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    }


    /**
     * Return a StandardServiceRegistryBuilder to be used in DAOs
     * @return
     */
    public StandardServiceRegistryBuilder getBuilder(){
        //Configure Hibernate
        Configuration hibernateConfig = new Configuration();
        Properties dbprops = new Properties();

        /**
         *this reads my db.properties file
         */

        try (InputStreamReader inputStream = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("db.properties"))) {
            dbprops.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * Set up Properties for my db connection, so hibernate can work.
         */
        Properties p = new Properties();
        p.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL9Dialect");
        p.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");

        /**
         * using my enviroment variable so that hibernate can actually read the database, and set the properties
         */
        p.setProperty("hibernate.connection.url",dbprops.getProperty("url"));
        p.setProperty("hibernate.connection.username",dbprops.getProperty("username"));
        p.setProperty("hibernate.connection.password",dbprops.getProperty("password"));
        hibernateConfig.setProperties(p);
        hibernateConfig.configure();


        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(hibernateConfig.getProperties());
        return builder;
    }
}

