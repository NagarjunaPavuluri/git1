package com.testex.junittestex;

import com.testex.junittestex.Entity.Employee;
import com.testex.junittestex.Repository.EmployeeRepo;
import com.testex.junittestex.service.employeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class employeeServiceTests {

    @Mock
    EmployeeRepo employeeRepo;
    @InjectMocks
    employeeServiceImpl employeeservice;
    private Employee e1;
    @BeforeEach
    public void setUp(){
        //e= new Employee(1,"nag","pavuluri","nag@gmail.com");
        e1=Employee.builder()
                .id(1L)
                .firstname("n")
                .lastname("p")
                .email("np@gmail.com")
                .build();
    }
    @Test
    public void findusingId(){
        when(employeeRepo.findById(1L)).thenReturn(Optional.of(e1));
        Employee se=employeeservice.getById(e1.getId());
        Assertions.assertEquals(se.getId(),1);
    }
}
