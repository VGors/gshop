package com.gorvic.gshop.repositories;

import com.gorvic.gshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(float price);

    List<Product> findAllByPriceLessThan(float price);

    List<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(float min_price, float max_price);
}
