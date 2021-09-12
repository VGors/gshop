package com.gorvic.gshop.controllers;

import com.gorvic.gshop.dto.ProductDto;
import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.CategoryService;
import com.gorvic.gshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id));
    }

    @GetMapping
    public Page<Product> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        return productService.findPage(pageIndex - 1, 7);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setTitle(newProductDto.getTitle());
        product.setPrice(newProductDto.getPrice());
        Category category = categoryService.findByTitle(newProductDto.getCategoryTitle());
        product.setCategory(category);
        return new ProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
