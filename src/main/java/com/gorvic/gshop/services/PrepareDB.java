package com.gorvic.gshop.services;

import org.hibernate.Session;
import com.gorvic.gshop.GshopApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDB {
    public void createDB(){
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("products.sql")).collect(Collectors.joining(" "));
            session = GshopApplication.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
