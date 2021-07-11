package com.gorvic.gshop.models;

import com.gorvic.gshop.GshopApplication;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProducts {
    private Session session;
    public Product findById(Long id){
        session = GshopApplication.sessionFactory.getCurrentSession();

    }
    public List<Product> findAll{
        session = GshopApplication.sessionFactory.getCurrentSession();

    }
    public void deleteById(Long id){
        session = GshopApplication.sessionFactory.getCurrentSession();

    }
    public Product saveOrUpdate(Product product){
        session = GshopApplication.sessionFactory.getCurrentSession();

    }

    public void createProduct(String title, float price){
        session = GshopApplication.sessionFactory.getCurrentSession();

    }

}
