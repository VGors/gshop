package com.gorvic.gshop.controllers;

import com.gorvic.gshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/add")
    public String showAddNewProductPage() {
        return "addProduct";
    }

    @PostMapping("/add")
    public String addNewProduct(@RequestParam String title, @RequestParam float price) {
        productService.addNewProduct(title, price);
        return "redirect:/";
    }

    @GetMapping("/prodInfo{id}")
    public String showProductInfo(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProductById(id));
        return "productInfo";
    }

}
