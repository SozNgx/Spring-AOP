package com.example.demo.Servive;

import com.example.demo.Entity.Employee;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService{

    public Employee creat(String id, String name){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        return emp;
    }

    public void delete(String id){

    }

    public void getByID(String id){

    }
}
