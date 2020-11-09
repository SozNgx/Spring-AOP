package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Servive.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/creat/{id}/{name}")
    public Employee creat(String id, String name){
        return employeeService.creat(id, name);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(String id){
        employeeService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public void get(String id){

    }

}
