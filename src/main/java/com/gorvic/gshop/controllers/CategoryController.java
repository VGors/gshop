package com.gorvic.gshop.controllers;

import com.gorvic.gshop.services.CategoryService;
import com.gorvic.gshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories/add")
    public String showAddNewProductPage() {
        return "addProduct";
    }

    @PostMapping("/categories/add")
    public String addNewProduct(@RequestParam String title) {
        categoryService.addNewCategory(title);
        return "redirect:/";
    }

    @GetMapping("/categories/{id}")
    public String showProductInfo(Model model, @PathVariable Long id){
        model.addAttribute("category", categoryService.findById(id));
        return "categoryInfo";
    }
}
