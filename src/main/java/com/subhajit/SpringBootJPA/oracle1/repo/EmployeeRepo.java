/**
 * One repository per entity.
 * You cannot manage multiple entities in a single JpaRepository interface.
 * Create a new repository interface for each entity you want to manage.
 */
/**
 * EmployeeRepo is a Spring Data JPA repository interface.
 * It extends JpaRepository, which is a Spring Data interface that provides built-in CRUD (Create, Read, Update, Delete) operations and more for your entity.
 * <EmployeeEntity, Long> means:
 * EmployeeEntity is the entity class this repository manages (should be annotated with @Entity).
 * Long is the type of the primary key (ID) of EmployeeEntity.
 * By extending JpaRepository, EmployeeRepo automatically inherits methods like save(), findById(), findAll(), deleteById(), etc., without you needing to write their implementations.
 */

package com.subhajit.SpringBootJPA.oracle1.repo;

import com.subhajit.SpringBootJPA.oracle1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
}
