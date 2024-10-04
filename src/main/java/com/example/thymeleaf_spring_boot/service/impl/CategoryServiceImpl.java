package com.example.thymeleaf_spring_boot.service.impl;

import com.example.thymeleaf_spring_boot.model.Category;
import com.example.thymeleaf_spring_boot.repository.CategoryRepo;
import com.example.thymeleaf_spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}