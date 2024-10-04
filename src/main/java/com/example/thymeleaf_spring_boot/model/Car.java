package com.example.thymeleaf_spring_boot.model;

import jakarta.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name ="car_sequence",
            sequenceName ="car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String make;
    private String model;
    private int year;
    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Car() {}

    public Car(String make, String model, int year, String color, Category category) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}