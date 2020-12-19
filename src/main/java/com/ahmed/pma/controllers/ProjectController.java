package com.ahmed.pma.controllers;

import com.ahmed.pma.dao.EmployeeRepository;
import com.ahmed.pma.dao.ProjectRepository;
import com.ahmed.pma.entities.Employee;
import com.ahmed.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects= projectRepository.findAll();
        model.addAttribute("projectsList",projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject=new Project();
        model.addAttribute("project",aProject);
        List<Employee> employees=employeeRepository.findAll();
        model.addAttribute("allEmployees",employees);
        return "projects/new-project";
    }



    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model){
        projectRepository.save(project) ;
        Iterable<Employee> chosenEmployees=employeeRepository.findAllById(employees);
        for(Employee emp: chosenEmployees){
            emp.setProject(project);
            employeeRepository.save(emp);
        }
        //use redirect to prevent duplicate submissions
        return"redirect:/projects/new";
    }
}
