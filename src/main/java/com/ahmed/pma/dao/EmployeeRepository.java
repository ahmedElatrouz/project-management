package com.ahmed.pma.dao;

import com.ahmed.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Override
    List<Employee> findAll();
}
