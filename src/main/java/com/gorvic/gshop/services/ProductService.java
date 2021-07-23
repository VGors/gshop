package com.gorvic.gshop.services;

import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findByMinPrice(float price){
        return productRepository.findAllByPriceGreaterThanEqual(price);
    }

    public void addNewProduct(String title, float price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        //Checks block
        productRepository.save(product);
    }
}
