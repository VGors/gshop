package com.gorvic.gshop.services;

import com.gorvic.gshop.models.Category;
import com.gorvic.gshop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
    public Category findByTitle(String title){
        return categoryRepository.getFirstByTitle(title);
    }
}
