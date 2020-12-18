package com.ahmed.pma.dao;

import com.ahmed.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
