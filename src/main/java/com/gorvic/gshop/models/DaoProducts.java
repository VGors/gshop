package com.gorvic.gshop.models;

import com.gorvic.gshop.GshopApplication;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProducts {
    private Session session;

    public Product findById(Long id) {
        session = GshopApplication.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product targetProduct = session.get(Product.class, id);
        session.beginTransaction().commit();
        return targetProduct;
    }

    public List<Product> findAll() {
        session = GshopApplication.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> allProducts = session.createQuery("from Product").getResultList();
        session.beginTransaction().commit();
        return allProducts;
    }

    public void deleteById(Long id) {
        session = GshopApplication.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product deletingProduct = session.get(Product.class, id);
        session.delete(deletingProduct);
        session.beginTransaction().commit();
    }

    //TEST
    public Product saveOrUpdate(Product product) {
        session = GshopApplication.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product updatedProduct = session.get(Product.class, product.getId());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setTitle(product.getTitle());
        session.beginTransaction().commit();
        return updatedProduct;
    }

    public void createProduct(String title, float price) {
        session = GshopApplication.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product newProduct = new Product(null, title, price);
        session.save(newProduct);
        session.beginTransaction().commit();
    }

}
