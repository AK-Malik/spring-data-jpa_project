/**
 * One repository per entity.
 * You cannot manage multiple entities in a single JpaRepository interface.
 * Create a new repository interface for each entity you want to manage.
 */

package com.subhajit.SpringBootJPA.oracle1.entity;


import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

/**
 * Entity Manager
 */
//QAK: What if we don't want any primary Key in Table? Must to have primary key in spring key
//@Entity
//@Table(name="JPA_ANIL_1")
//public class AnilEntity {
//    @Id                       // @Id - to specify the primary Key in the table.
//    @Column(name="EMP_ID")    //Column Name
//    private Long empId;       //Column Data Type
//
//    @Column(name="EMP_NAME", length = 10)
//    private String empName;
//
//    @Column(name="EMP_CITY", length = 10)
//    private String empCity;
//
//    public Long getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Long empId) {
//        this.empId = empId;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getEmpCity() {
//        return empCity;
//    }
//
//    public void setEmpCity(String empCity) {
//        this.empCity = empCity;
//    }
/****************************/
@Entity
@Table(name="JPA_EMPLOYEE")
public class AnilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long emp_Id;

    @Column(name = "EMP_EMAIL_ID", length = 20)
    private String empEmailId;

    @Column(name = "EMP_Name", length = 15)
    private String emp_Name;

    @Column(name = "EMP_DEPT", length = 10)
    private String emp_Dept;

    @Column(name = "EMP_LOCATION", length = 10)
    private String empLocation;

    public Long getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(Long emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmpEmailId() {
        return empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_Dept() {
        return emp_Dept;
    }

    public void setEmp_Dept(String emp_Dept) {
        this.emp_Dept = emp_Dept;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }
}
//QAK- CAN WE HAVE 2 ACTIVE ENTITY. E,G, ABOVE AND BELOW IF I UNCOMMENT
//@Entity
//@Table(name="EMPLOYEE_RECORD")
//public class AnilEntity
//{
//    /**
//     * @Id marks the field as the primary key.
//     * @GeneratedValue(strategy = GenerationType.IDENTITY) tells JPA to let the database automatically generate a unique value for this field (usually using an auto-increment column in databases like MySQL, PostgreSQL, SQL Server, etc.).
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="EMP_ID")
//    private long empId;
//
//    @Column(name ="EMP_NAME", length = 10, nullable = false)
//    private String empName;
//
//    @Column(name="EMP_DEPT", length = 5)
//    private String empDept;
//
//    @Column(name="EMP_CITY", length = 10)
//    private String empCity;
//
//    @Column(name ="EMP_STATE", length = 10) //,nullable = false,insertable=true,updatable=true)
//    private String empState;
//
//    public long getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(long empId) {
//        this.empId = empId;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getEmpDept() {
//        return empDept;
//    }
//
//    public void setEmpDept(String empDept) {
//        this.empDept = empDept;
//    }
//
//    public String getEmpCity() {
//        return empCity;
//    }
//
//    public void setEmpCity(String empCity) {
//        this.empCity = empCity;
//    }
//
//    public String getEmpState() {
//        return empState;
//    }
//
//    public void setEmpState(String empState) {
//        this.empState = empState;
//    }
//}

