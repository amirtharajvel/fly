package com.fly.service;

import com.fly.model.Employee;
import com.fly.repository.AccountRepository;
import com.fly.repository.EmployeeRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityManager entityManager;

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

        //Employee employee = employeeRepository.findById(id).get();
        //employeeRepository.delete(employee);

        //System.out.println("Employee is " + employee.getAccount());

        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deleteEmployeeFilter");
        filter.setParameter("isDeleted", true);
        Set<Employee> employeeList = employeeRepository.findAll();
        System.out.println(employeeList);
    }

}
