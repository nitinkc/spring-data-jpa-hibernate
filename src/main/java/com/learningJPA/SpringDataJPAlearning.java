package com.learningJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.learningJPA.dSpringDataRepository",
                    "com.learningJPA.eTest.model"})  // scan JPA entities
public class SpringDataJPAlearning {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPAlearning.class, args);
    }
}