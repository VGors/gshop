package com.gorvic.gshop;

import com.gorvic.gshop.services.PrepareDB;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GshopApplication {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            PrepareDB prepareDB = new PrepareDB();
            prepareDB.createDB();
            SpringApplication.run(GshopApplication.class, args);
        } finally {
            sessionFactory.close();
        }
    }
}
