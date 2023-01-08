package com.employee.Employee.controller;

import com.employee.Employee.entity.Employee;
import com.employee.Employee.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public  ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.updateEmployee(employee,id);
    }

    @GetMapping("/filterByName")
    public  ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
        return  ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByName(name));
    }

    @GetMapping("/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeNameAndLocation(@RequestParam String name, @RequestParam String location){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByNameAndLocation(name,location));
    }









}
