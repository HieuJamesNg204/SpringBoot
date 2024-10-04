package com.demo.spring_demo.configuration;

import com.demo.spring_demo.model.Student;
import com.demo.spring_demo.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student student = new Student(
                    "Hieu",
                    "HieuJames204@outlook.com",
                    LocalDate.of(2004, Month.APRIL, 20)
            );

            Student student2 = new Student(
                    "Thao",
                    "vthao@outlook.com",
                    LocalDate.of(2006, Month.OCTOBER, 11)
            );

            repo.saveAll(
                    List.of(student, student2)
            );
        };
    }
}
