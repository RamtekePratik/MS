package com.mastercard.demo.demo.services;


import com.mastercard.demo.demo.entities.Department;
import com.mastercard.demo.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;

    public void saveDepartment(Department department)
    {
        departmentRepository.save(department);

    }

    public Department findById(int id)
    {
        Department dept = departmentRepository.findById(id).orElse(null);

        return dept;
    }
}
