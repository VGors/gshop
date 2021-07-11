package com.gorvic.gshop.repositories;

import com.gorvic.gshop.exceptions.UniversalException;
import com.gorvic.gshop.models.DaoProducts;
import com.gorvic.gshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private DaoProducts daoProducts;

    @Autowired
    public ProductRepository(DaoProducts daoProducts) {
        this.daoProducts = daoProducts;
    }

    public Product getProductById(Long id) {
        return daoProducts.findById(id);
    }

    public List<Product> getAllProducts() {
        return daoProducts.findAll;
    }

    public void addNewProduct(Product product) {
        daoProducts.createProduct(product.getTitle(), product.getPrice());
    }

    public void deleteProduct(Long id){
        daoProducts.deleteById(id);
    }

    public Product changeProduct(Product product){
        return daoProducts.saveOrUpdate(product);
    }
}
