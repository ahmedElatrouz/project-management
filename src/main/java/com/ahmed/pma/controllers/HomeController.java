package com.ahmed.pma.controllers;

import com.ahmed.pma.dao.EmployeeRepository;
import com.ahmed.pma.dao.ProjectRepository;
import com.ahmed.pma.entities.Employee;
import com.ahmed.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model){
       List<Project> projects= proRepo.findAll();
       model.addAttribute("projectsList",projects);
       List<Employee> employees=empRepo.findAll();
        model.addAttribute("employeesList",employees);
       return "main/home";
    }


}
