package com.example.thymeleaf_spring_boot.controller;

import com.example.thymeleaf_spring_boot.model.Car;
import com.example.thymeleaf_spring_boot.model.Category;
import com.example.thymeleaf_spring_boot.service.CarService;
import com.example.thymeleaf_spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CategoryService categoryService;

    @Autowired
    public CarController(CarService carService, CategoryService categoryService) {
        this.carService = carService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car-list";
    }

    @GetMapping("/new")
    public String createCarForm(Model model) {
        Car car = new Car();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("car", car);
        model.addAttribute("categories", categories);
        return "car-form";
    }

    @PostMapping
    public String saveCar(@ModelAttribute("car") @Validated Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "car-form"; // Return back to the form to fix errors
        }
        carService.saveCar(car);
        return "redirect:/cars";
    }


    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("car", car);
        model.addAttribute("categories", categories);
        return "car-edit";
    }


    @PutMapping("/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car) {
        Car existingCar = carService.getCarById(id);
        existingCar.setMake(car.getMake());
        existingCar.setModel(car.getModel());
        existingCar.setYear(car.getYear());
        existingCar.setColor(car.getColor());
        existingCar.setCategory(car.getCategory());
        carService.saveCar(existingCar);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}