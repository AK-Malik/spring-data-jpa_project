package com.subhajit.SpringBootJPA.oracle1.repo;

import com.subhajit.SpringBootJPA.oracle1.entity.EmployeeEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * One repository per entity.
 * You cannot manage multiple entities in a single JpaRepository interface.
 * Create a new repository interface for each entity you want to manage.
 */
/**
 * EmployeeJpaSqlRepo is a Spring Data JPA repository interface.
 * It extends JpaRepository, which is a Spring Data interface that provides built-in CRUD (Create, Read, Update, Delete) operations and more for your entity.
 * for manual queries or using JPQL /SQL, use the return type as this example shows
 * <EmployeeEntity, Long> means:
 * EmployeeEntity is the entity class this repository manages (should be annotated with @Entity).
 * Long is the type of the primary key (ID) of EmployeeEntity.
 * By extending JpaRepository, EmployeeJpaSqlRepo automatically inherits methods like save(), findById(), findAll(), deleteById(), etc., without you needing to write their implementations.
 */
public interface EmployeeJpaSqlRepo extends JpaRepository<EmployeeEntity, Long> {
// JPQL custom query
    /**
     * @Query(...)
     * This annotation is used in Spring Data JPA to define a custom JPQL (Java Persistence Query Language) query for a repository method.
     * "SELECT ae FROM EmployeeEntity ae WHERE ae.empId = :empId"
     * This is a JPQL query (similar to SQL, but uses entity and field names, not table/column names). ae is an alias for the EmployeeEntity entity.
     * The query selects the EmployeeEntity where its empId field matches the provided parameter :empId.
     * EmployeeEntity findByIdJPQL(...) : This method will execute the above query and return the matching EmployeeEntity object.
     * @Param("empId") Long empId  , Binds the method parameter empId to the named parameter :empId in the JPQL query.
     * Summary
     * This method allows you to fetch an EmployeeEntity by its empId using a custom JPQL query in a Spring Data JPA repository.
     * The query uses entity and field names (not table/column names).
     * The @Param annotation binds the method parameter to the query parameter.
     * @param empId
     * @return
     */

    /**
     * Fetch an Employee By an ID
     * @param empId
     * @return
     */
    @Query("SELECT ae FROM EmployeeEntity ae WHERE ae.empId = :empId") //@Query(value = "SELECT ae from EmployeeEntity ae where ae.empId = :empId", nativeQuery = false)  //JPQL query structure, pojo/entity
    EmployeeEntity findByIdJPQL(@Param("empId") Long empId);   //EmployeeEntity findByIdJPQL(Long empId);  //custom method for JPQL

    /**
     * Fetch all the records of an employee using JPQL
     * @return
     */
    @Query(value = "SELECT ae from EmployeeEntity ae", nativeQuery = false)   //return the full table , one object at a time
    List<EmployeeEntity> findAllJPQL(); // custom
/**
 * JPQL doesn't support insert statement . for this it should be taken
 */
//    @Query(value = "INSERT INTO ae  EmployeeEntity ae", nativeQuery = false)
//    List<EmployeeEntity> saveRecordUsingJpql();
//

    /**
     * Using JPQL, Add an employee record if doesn't exist or update if exist
     * @param empId
     * @param empName
     * @param empCity
     * @param empDept
     * @param empState
     * @return
     */
    @Modifying
    @Query(value ="UPDATE EmployeeEntity ae SET ae.empName= :empName,ae.empCity=:empCity, ae.empDept=:empDept,ae.empState=:empState WHERE ae.empId =:empId")
    EmployeeEntity updateRecordUsingJpql(@Param("empId") Long empId, @Param("empName") String empName,@Param("empCity") String empCity,@Param("empDept") String empDept,@Param("empState") String empState);
  //QAK why not used and then how its working
    /**
     * Delete a record using JPQL
     * @param empId
     * @return
     */
    @Modifying
    @Query("DELETE FROM EmployeeEntity ae WHERE ae.empId=:empId")
    void deleteByIdJpql(@Param("empId") Long empId);  //int deleteByIdJpql(@Param("empId") Long empId);


    //SQL
    @Query(value = "SELECT * from EMPLOYEE_RECORD where EMP_ID = :empId", nativeQuery = true)
    EmployeeEntity findByIdSQL(Long empId); // custom

    @Query(value = "SELECT * from EMPLOYEE_RECORD", nativeQuery = true)
    List<EmployeeEntity> findAllSQL(); // custom


}


