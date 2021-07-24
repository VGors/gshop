package com.gorvic.gshop.controllers;

import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> showMainPage() {
        return productService.findAll();
    }

    @GetMapping("/products/add")
    public String showAddNewProductPage() {
        return "addProduct";
    }

    @PostMapping("/products/add")
    public String addNewProduct(@RequestParam String title, @RequestParam float price) {
        productService.addNewProduct(title, price);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public Product showProductInfo(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    //    http://localhost:8189/gshop/products/more_min_price?min=800
    @GetMapping("/products/more_min_price")
    public List<Product> findMoreMinPrice(@RequestParam(name = "min") float min) {
        return productService.findMoreMinPrice(min);
    }

    //    http://localhost:8189/gshop/products/less_max_price?max=100
    @GetMapping("/products/less_max_price")
    public List<Product> findLessMaxPrice(@RequestParam(name = "max") float max) {
        return productService.findLessMaxPrice(max);
    }

    //    http://localhost:8189/gshop/products/between_min_max?min=40&max=780
    @GetMapping("/products/between_min_max")
    public List<Product> findBetweenMinMaxPrice(@RequestParam(name = "min") float min, @RequestParam(name = "max") float max) {
        return productService.findBetweenMinMaxPrice(min, max);
    }
}
