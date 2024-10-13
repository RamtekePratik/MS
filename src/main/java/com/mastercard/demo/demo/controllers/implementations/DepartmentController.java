package com.mastercard.demo.demo.controllers.implementations;

import com.mastercard.demo.demo.async.AsyncTaskScheduler;
import com.mastercard.demo.demo.controllers.interfaces.DepartmentControllerInterface;
import com.mastercard.demo.demo.entities.Department;
import com.mastercard.demo.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentController implements DepartmentControllerInterface {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AsyncTaskScheduler asyncTaskScheduler;
    @Override
    public ResponseEntity<Department> createDepartment(Department department) {
        departmentService.saveDepartment(department);

        Department dept = departmentService.findById(department.getId());
        asyncTaskScheduler.performTask();

        return ResponseEntity.status(HttpStatus.CREATED).body(dept);
    }

    @Override
    public ResponseEntity<Department> findById(int id) {
        Department dept = departmentService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(dept);
    }
}
