package com.gorvic.gshop.repositories;

import com.gorvic.gshop.exceptions.UniversalException;
import com.gorvic.gshop.models.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
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

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(0L, "Celery", 50.32f),
                new Product(1L, "Parsley", 30.11f),
                new Product(2L, "Fennel", 10),
                new Product(3L, "Coriander", 46.7f)
        ));
    }

}
