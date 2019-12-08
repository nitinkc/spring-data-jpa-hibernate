package com.learningJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"cPersistenceContext", "com.learningJPA"})
@ComponentScan(basePackages = {"dSpringDataRepository", "com.learningJPA"})
public class SpringDataJPALearning {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPALearning.class, args);
	}
}
