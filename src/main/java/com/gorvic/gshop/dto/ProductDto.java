package com.gorvic.gshop.dto;

import com.gorvic.gshop.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String categoryTitle;
    private float price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.categoryTitle = product.getCategory().getTitle();
        this.price = product.getPrice();
    }

    public ProductDto(Long id, String title, String categoryTitle, float price) {
        this.id = id;
        this.title = title;
        this.categoryTitle = categoryTitle;
        this.price = price;
    }
}
