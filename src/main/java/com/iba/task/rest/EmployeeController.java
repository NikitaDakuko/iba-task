package com.iba.task.rest;

import com.iba.task.dto.Employee;
import com.iba.task.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/employees")
    public void create(@RequestBody Employee newEmployee) {
        employeeDao.addEmployee(newEmployee);
    }

    @GetMapping("/allEmployees")
    public List<Employee> read() {
        return employeeDao.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee readOne(@PathVariable Long id) {
        return employeeDao.getEmployeeByID(id);
    }

    @PutMapping("/employees/{id}")
    void update(@PathVariable Long id, @RequestBody Employee newEmployee) {
        employeeDao.updateEmployee(id, newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    void delete(@PathVariable Long id) {
        employeeDao.deleteEmployee(id);
    }
}
