package com.testex.junittestex;

import com.testex.junittestex.Entity.Employee;
import com.testex.junittestex.Repository.EmployeeRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTests {

    @Autowired
    EmployeeRepo employeeRepo;

    @Test
    @Order(1)
    @Rollback(value = false) //--each test case is in its own transaction so to remove that using rollback if they are in same transaction then other test cant use its data
    public void saveEmployee(){
        Employee e=new Employee();
        e.setEmail("nag@gmail.com");
        e.setFirstname("Nag");
        e.setLastname("Pavuluri");

        employeeRepo.save(e);
        System.out.println("employee id is -------------"+e.getId());

        Assertions.assertTrue(e.getId()>0,"data inserted");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getEmployee(){
        Employee e=employeeRepo.findById(1L).get();
        Long id=e.getId();
        System.out.println("employee id is -------------"+id);

        Assertions.assertTrue(e.getId()==1);
    }

    @Test
    @Order(3)
    public void updateEmployee(){
        Employee e=employeeRepo.findById(1L).get();
        e.setEmail("naga@gmail.com");
        employeeRepo.save(e);

        Assertions.assertTrue(e.getEmail().equals("naga@gmail.com"));
    }



}
