package com.gorvic.gshop.controllers;

import com.gorvic.gshop.models.Product;
import com.gorvic.gshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("products", productService.findAll());
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
        model.addAttribute("product", productService.findById(id));
        return "productInfo";
    }

    @GetMapping("/find_by_price")
    @ResponseBody
    public List<Product> findByPrice(@RequestParam(name = "min") float min){
        return productService.findByMinPrice(min);
    }

}
