package com.mastercard.demo.demo.controllers.interfaces;


import com.mastercard.demo.demo.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@Controller
@RestController
public interface EmployeeControllerInterface {


    @PostMapping(value = "/create/user", consumes = "Application/json",produces = "Application/json")
    @Transactional
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee);


}
