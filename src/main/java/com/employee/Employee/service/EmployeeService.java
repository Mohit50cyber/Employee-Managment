package com.employee.Employee.service;

import com.employee.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(Employee e, int id);

    public void deleteEmployee(int id);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);
}
