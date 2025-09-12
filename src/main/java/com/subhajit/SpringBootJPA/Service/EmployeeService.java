package com.subhajit.SpringBootJPA.Service;

import com.subhajit.SpringBootJPA.oracle1.entity.EmployeeEntity;
import com.subhajit.SpringBootJPA.oracle1.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<Void> addEmployee(EmployeeEntity employeeEntity) {
        employeeRepo.save(employeeEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<List<EmployeeEntity>> fetchAllEmployeeRecords() {
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);

    }

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<EmployeeEntity> fetchAnEmployeeRecord(Long empId) {
    EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeRepo.findById(empId).get();
    return  new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<Void> deleteAnEmployeeById(Long empId) {
        employeeRepo.deleteById(empId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<Void> updateAnEmployeeById(Long empId,  EmployeeEntity employeeEntityIncoming) {
        EmployeeEntity employeeEntityExisting = employeeRepo.findById(empId).get();
        employeeEntityExisting.setEmpCity(employeeEntityIncoming.getEmpState());
        employeeEntityExisting.setEmpName(employeeEntityIncoming.getEmpName());
        employeeEntityExisting.setEmpDept(employeeEntityIncoming.getEmpDept());
        employeeEntityExisting.setEmpState(employeeEntityIncoming.getEmpCity());
        employeeRepo.save(employeeEntityExisting);
        System.out.println("Updated Employee Record: "+employeeEntityExisting);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    }