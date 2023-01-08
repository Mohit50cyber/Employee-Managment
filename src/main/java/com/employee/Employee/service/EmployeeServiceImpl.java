package com.employee.Employee.service;

import com.employee.Employee.entity.Employee;
import com.employee.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee e ,int id) {
        Employee employee= this.employeeRepository.findById(id).get();
        if(employee.getId()==e.getId()){
            employee.setDepartment(e.getDepartment());
            employee.setName(e.getName());
            employee.setAge(e.getAge());
            employee.setEmail(e.getEmail());
            employee.setLocation(e.getLocation());
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return this.employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return this.employeeRepository.findByNameAndLocation(name, location);
    }


}
