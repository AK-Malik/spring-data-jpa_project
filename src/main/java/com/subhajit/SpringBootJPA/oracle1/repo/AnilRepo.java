package com.subhajit.SpringBootJPA.oracle1.repo;



import com.subhajit.SpringBootJPA.oracle1.entity.AnilEntity;
import com.subhajit.SpringBootJPA.oracle1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TransactionManager
 * AnilRepo is a Spring Data JPA repository interface (Java Persistent API).
 * It extends JpaRepository, which is a Spring Data interface that provides CRUD (Create, Read, Update, Delete) operations and more for your entity.
 * <AnilEntity, Long> means:
 * AnilEntity is the entity class this repository manages (typically a class annotated with @Entity).
 * Long is the type of the primary key (ID) of AnilEntity.
 * By extending JpaRepository, AnilRepo automatically inherits methods like save(), findById(), findAll(), deleteById(), etc., without needing to write their implementations.
 * Summary:
 * This interface allows you to perform database operations on AnilEntity objects using Spring Data JPA, with Long as the ID type, and you don’t need to write boilerplate CRUD code.
 */

/**
 * Boilerplate code refers to sections of code that are repeated in many places with little or no variation. It is often required by the programming language or framework to accomplish common tasks, but it does not contain any unique logic for your specific application.
 * Examples in Java:
 * Getters and setters for fields in a class, Standard code for opening/closing files or database connections
 * Implementing CRUD methods in repositories
 * In context: Spring Data JPA removes the need to write boilerplate code for database operations by providing interfaces like JpaRepository, so you don’t have to write the same CRUD methods for every entity.
 */

public interface AnilRepo extends JpaRepository<AnilEntity, Long>{

}
