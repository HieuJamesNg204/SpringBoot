package com.example.thymeleaf_spring_boot.service;

import com.example.thymeleaf_spring_boot.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car saveCar(Car car);
    void deleteCar(Long id);
}