package com.mastercard.demo.demo.repositories;

import com.mastercard.demo.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findById(int id);

    @Query("SELECT e FROM Employee e WHERE e.name= :name")
    public List<Employee> getAllEmployeeByName(@Param("name") String name);
}
