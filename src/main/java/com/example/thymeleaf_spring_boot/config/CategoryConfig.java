package com.example.thymeleaf_spring_boot.config;

import com.example.thymeleaf_spring_boot.model.Car;
import com.example.thymeleaf_spring_boot.model.Category;
import com.example.thymeleaf_spring_boot.repository.CarRepo;
import com.example.thymeleaf_spring_boot.repository.CategoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepo categoryRepo, CarRepo carRepo) {
        return args -> {
            List<Category> categoryList = List.of(
                    new Category("Sedan"),
                    new Category("Hatchback"),
                    new Category("SUV"),
                    new Category("MPV"),
                    new Category("Pickup truck")
            );

            Car car = new Car("Toyota", "Corolla", 2024, "White", categoryList.get(0));

            categoryRepo.saveAll(categoryList);
            carRepo.saveAll(List.of(car));
        };
    }
}