package com.fly.service;

import com.fly.model.Employee;
import com.fly.repository.AccountRepository;
import com.fly.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void lets(String name) {

        Employee murugan = new Employee(name);
        try {
            Employee saved = employeeRepository.save(murugan);
            System.out.println();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void second(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        System.out.println("Employee is " + employee.getAccount());
    }

}
