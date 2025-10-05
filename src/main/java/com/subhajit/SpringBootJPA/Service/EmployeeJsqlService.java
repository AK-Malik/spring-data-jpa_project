package com.subhajit.SpringBootJPA.Service;

import com.subhajit.SpringBootJPA.oracle1.entity.EmployeeEntity;
import com.subhajit.SpringBootJPA.oracle1.repo.EmployeeJpaSqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeJsqlService {
    @Autowired
    private EmployeeJpaSqlRepo employeeJpaSqlRepo;

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<EmployeeEntity> fetchDataJPQL(Long empId) {
//        if (empId == null) {
//            System.out.println("empId is null");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        EmployeeEntity employeeEntity = employeeJpaSqlRepo.findByIdJPQL(empId);

        if (employeeEntity == null) {
            System.out.println("Record doesn't exist for: " + empId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }
//Fetch all Employee Records
    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<List<EmployeeEntity>> fetchAllEmployeeRecordsWithJpql() {
        List<EmployeeEntity> employeeEntity= employeeJpaSqlRepo.findAllJPQL();
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

//Add an EmployeeRecord using Jpql
//    @Transactional("oracle1-jpaTransactionManager")
//    public ResponseEntity<Void> addEmployeeRecord( EmployeeEntity employeeEntity) {
//        if(employeeEntity==null ){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        employeeJpaSqlRepo.saveRecordUsingJpql();
//        System.out.println("Employee Record has been added in Employee_Record Table: " + employeeEntity);
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
@Transactional("oracle1-jpaTransactionManager")
public ResponseEntity<Void> updateAnEmployeeById(Long empId, EmployeeEntity employeeEntityIncoming) {
    EmployeeEntity employeeEntityExisting = employeeJpaSqlRepo.findByIdJPQL(empId);

    if (employeeEntityExisting != null) {
        // Update existing record
        employeeEntityExisting.setEmpCity(employeeEntityIncoming.getEmpCity());
        employeeEntityExisting.setEmpDept(employeeEntityIncoming.getEmpDept());
        employeeEntityExisting.setEmpName(employeeEntityIncoming.getEmpName());
        employeeEntityExisting.setEmpState(employeeEntityIncoming.getEmpState());
        employeeJpaSqlRepo.save(employeeEntityExisting);
        System.out.println("Employee Record has been updated in Employee_Record Table: " + employeeEntityExisting);
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        // Add new record
        employeeJpaSqlRepo.save(employeeEntityIncoming);
        System.out.println("Employee Record has been added in Employee_Record Table: " + employeeEntityIncoming);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

    /**
     * using JPQL, delete an employee entity record
     * @param empId
     * @return
     */

    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<Void> deleteAnEmployeeById(Long empId) {
        EmployeeEntity employeeEntity = employeeJpaSqlRepo.findByIdJPQL(empId);
        if (employeeEntity == null) {
            System.out.println("Record doesn't exist for: " + empId);
        }
        employeeJpaSqlRepo.deleteByIdJpql(empId);
        System.out.println("Employee Record "+empId +" has been deleted in Employee_Record Table: ");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @Transactional("oracle1-jpaTransactionManager")
    public ResponseEntity<EmployeeEntity> fetchDataSQL(Long empId){
    EmployeeEntity employeeEntity =  employeeJpaSqlRepo.findByIdSQL(empId);
    if(employeeEntity !=null) {
        System.out.println("Employee Record " + empId + " has been deleted in Employee_Record Table");
    }else{
        System.out.println("Unable to delete as, Employee Record "+empId+" doesn't exist in Employee_Record table");
        }
    return new ResponseEntity<>( HttpStatus.ACCEPTED);
}




//    @Transactional("oracle1-jpaTransactionManager")
//    public ResponseEntity<Void> updateAnEmployeeById(Long empId,  EmployeeEntity employeeEntityIncoming) {
//        EmployeeEntity employeeEntityExisting = employeeRepo.findById(empId).get();
//        employeeEntityExisting.setEmpCity(employeeEntityIncoming.getEmpState());
//        employeeEntityExisting.setEmpName(employeeEntityIncoming.getEmpName());
//        employeeEntityExisting.setEmpDept(employeeEntityIncoming.getEmpDept());
//        employeeEntityExisting.setEmpState(employeeEntityIncoming.getEmpCity());
//        employeeRepo.save(employeeEntityExisting);
//        System.out.println("Updated Employee Record: "+employeeEntityExisting);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }


}