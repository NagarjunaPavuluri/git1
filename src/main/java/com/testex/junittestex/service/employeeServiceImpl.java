package com.testex.junittestex.service;

import com.testex.junittestex.Entity.Employee;
import com.testex.junittestex.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class employeeServiceImpl implements employeeservice{

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee getById(Long id) {
        Employee e=employeeRepo.findById(id).get();
        return e;
    }

    @Override
    public void getAllemployees() {
        List<Employee> employees=employeeRepo.findAll();
    }
}
