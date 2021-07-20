package com.gorvic.gshop.models;

import com.gorvic.gshop.GshopApplication;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProducts {
    public Product findById(Long id) {

        try (Session session = GshopApplication.sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product targetProduct = session.get(Product.class, id);
//            session.beginTransaction().commit();
            return targetProduct;
        }
    }

    public List<Product> findAll() {
        try (Session session = GshopApplication.sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<Product> allProducts = session.createQuery("select s from Product s where s.id >= 0", Product.class).getResultList();
            return allProducts;
//            session.beginTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = GshopApplication.sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product deletingProduct = session.get(Product.class, id);
            session.delete(deletingProduct);
            session.beginTransaction().commit();
        }
    }

    //TEST
    public Product saveOrUpdate(Product product) {

        try (Session session = GshopApplication.sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product updatedProduct = session.get(Product.class, product.getId());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setTitle(product.getTitle());
            return updatedProduct;
//            session.beginTransaction().commit();
        }
    }

    public void createProduct(String title, float price) {
        try (Session session = GshopApplication.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product newProduct = new Product(45L, title, price);
            session.save(newProduct);
            session.beginTransaction().commit();
        }
    }

}
