package com.gorvic.gshop.repositories;

import com.gorvic.gshop.exceptions.UniversalException;
import com.gorvic.gshop.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public Product getProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new UniversalException();
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addNewProduct(Product product){
        Long id = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        product.setId(id);
        products.add(product);
    }
}
