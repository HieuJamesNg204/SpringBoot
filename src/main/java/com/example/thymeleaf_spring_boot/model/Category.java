package com.example.thymeleaf_spring_boot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name ="category_sequence",
            sequenceName ="category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}