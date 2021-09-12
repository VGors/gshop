package com.gorvic.gshop.controllers;

import com.gorvic.gshop.dto.CategoryDto;
import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id){
        return new CategoryDto(categoryService.findById(id));
    }
}
