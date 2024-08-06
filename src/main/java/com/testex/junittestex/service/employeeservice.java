package com.testex.junittestex.service;

import com.testex.junittestex.Entity.Employee;

public interface employeeservice {

    public Employee getById(Long id);
    public void getAllemployees();
}
