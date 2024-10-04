package com.example.thymeleaf_spring_boot.repository;

import com.example.thymeleaf_spring_boot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}