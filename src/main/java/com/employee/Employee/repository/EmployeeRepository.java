package com.employee.Employee.repository;

import com.employee.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    //select * from table where name="bhushan" and location="india"
    List<Employee> findByNameAndLocation(String name , String location);
}
