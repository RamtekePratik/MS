package com.mastercard.demo.demo.controllers.interfaces;

import com.mastercard.demo.demo.entities.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface DepartmentControllerInterface {

    @PostMapping("/department/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department);

    @GetMapping("/department/find/{id}")
    public ResponseEntity<Department> findById(@PathVariable("id") int id);

}
