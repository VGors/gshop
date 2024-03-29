package com.gorvic.gshop.services;

import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }
    public Category findByTitle(String title){
        return categoryRepository.getFirstByTitle(title);
    }
}
