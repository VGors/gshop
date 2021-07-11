package com.gorvic.gshop.services;

import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void addNewProduct(String title, float price) {
        //Checks block
        productRepository.addNewProduct(new Product(title, price));
    }
}
