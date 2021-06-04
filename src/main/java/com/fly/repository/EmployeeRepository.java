package com.fly.repository;


import com.fly.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Set<Employee> findAll();
}
