package com.subhajit.SpringBootJPA.oracle1.entity;

import javax.persistence.*;

/**
 * Entity Manager
 */
@Entity
@Table(name="EMPLOYEE_RECORD")
public class EmployeeEntity
{
    /**
     * @Id marks the field as the primary key.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) tells JPA to let the database automatically generate a unique value for this field (usually using an auto-increment column in databases like MySQL, PostgreSQL, SQL Server, etc.).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //for auto generated value. this column don't need to add in JSON or manual insert
    @Column(name="EMP_ID")
    private long empId;

    @Column(name ="EMP_NAME", length = 10) //QAK, nullable = true/false?
    private String empName;

    @Column(name="EMP_DEPT", length = 5)
    private String empDept;

    @Column(name="EMP_CITY", length = 10)
    private String empCity;

    @Column(name ="EMP_STATE", length = 10,nullable = false) //,nullable = false,insertable=true,updatable=true)
    private String empState;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpState() {
        return empState;
    }

    public void setEmpState(String empState) {
        this.empState = empState;
    }

    @Override
    public String toString() {
        return "EmployeeEntity: ["+empId+","+empName+","+empDept+","+empCity+","+empState+"]";
    }
}