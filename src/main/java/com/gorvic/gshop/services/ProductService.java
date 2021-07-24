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

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findMoreMinPrice(float price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    public List<Product> findLessMaxPrice(float price){
        return productRepository.findAllByPriceLessThan(price);
    }

    public List<Product> findBetweenMinMaxPrice(float min_price, float max_price){
        return productRepository.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(min_price, max_price);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void addNewProduct(String title, float price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        //Checks block
        productRepository.save(product);
    }
}
