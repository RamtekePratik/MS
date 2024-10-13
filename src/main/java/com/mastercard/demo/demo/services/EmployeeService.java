package com.mastercard.demo.demo.services;



import com.mastercard.demo.demo.configurations.conditional.MyConditionalBean;
import com.mastercard.demo.demo.entities.Employee;
import com.mastercard.demo.demo.repositories.EmployeeRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired(required = false)
    private MyConditionalBean myConditionalBean;

    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);


    public List<Employee> getEmployeeDetails(String name)
    {
        List<Employee> employees;
        try
        {
            employees = employeeRepository.getAllEmployeeByName(name);
        }
        catch(Exception e)
        {
            throw new DataIntegrityViolationException("Violated");
        }

        return employees;
    }

    @CachePut(value="Employee", key="#employee.id")
    public void persistUser(Employee employee)
    {
        if(employee!= null || !employee.getName().equals("fail"))
        {
            String name = myConditionalBean.getName();
            LOGGER.info("Conditional Name : "+name);
            employeeRepository.save(employee);

        }
        else
        {
            throw new TypeMismatchDataAccessException("NOT ALLOWED");
        }
    }


    public void m1(String name)
    {
        if(name.equals("Pratik"))
        {
            throw new RuntimeException("Not allowd Pratik : m1");
        }
        else
        {
            System.out.println("M1 worked");
            m2("PQR");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void m2(String name)
    {
        if(name.equals("ABC"))
        {
            throw new RuntimeException("Not allowd PQR : m2");
        }
        else
        {
            System.out.println("M2 worked");
        }
    }
}
