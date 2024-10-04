package com.example.thymeleaf_spring_boot.service.impl;

import com.example.thymeleaf_spring_boot.model.Car;
import com.example.thymeleaf_spring_boot.repository.CarRepo;
import com.example.thymeleaf_spring_boot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }
}