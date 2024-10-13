package com.mastercard.demo.demo.controllers.implementations;

import com.mastercard.demo.demo.configurations.DataBaseConfig;
import com.mastercard.demo.demo.controllers.interfaces.EmployeeControllerInterface;
import com.mastercard.demo.demo.entities.Employee;
import com.mastercard.demo.demo.repositories.EmployeeRepository;
import com.mastercard.demo.demo.services.EmployeeService;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    DataBaseConfig db;

    @Value("${spring.security.demo}")
    private String security;

    @GetMapping("/user")
    public ResponseEntity<String> getUser()
    {

        return ResponseEntity.status(HttpStatus.OK).body(db.getUrl());
    }

    @Override
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee)
    {
        try
        {
            if(employeeRepository.findById(employee.getId()) != null)
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(employee);
            }
            employeeService.persistUser(employee);

            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }

        catch(DataIntegrityViolationException e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(employee);
        }

    }

    @GetMapping(value = "/employee/getDetails/{name}")
    public List<Employee> getEmployeeDetails(@PathVariable("name")String name)
    {
        List<Employee> employees;
        try
        {
            employees = employeeService.getEmployeeDetails(name);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Exception");
        }

        return employees;
    }
}
