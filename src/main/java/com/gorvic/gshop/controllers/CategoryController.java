package com.gorvic.gshop.controllers;

import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public Category showProductInfo(@PathVariable Long id) {
        return categoryService.findById(id);
    }
}
