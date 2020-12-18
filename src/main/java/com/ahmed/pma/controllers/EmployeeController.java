package com.ahmed.pma.controllers;

import com.ahmed.pma.dao.EmployeeRepository;
import com.ahmed.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new-employee";
    }
    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }

}