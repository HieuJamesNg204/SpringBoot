package com.example.thymeleaf_spring_boot.service;

import com.example.thymeleaf_spring_boot.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Long id);
}