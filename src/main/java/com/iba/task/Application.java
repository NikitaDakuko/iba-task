package com.iba.task;

import com.iba.task.dao.EmployeeDao;
import com.iba.task.dto.Employee;
import com.iba.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void run(String... args) {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        if(employeeList == null) {
            System.out.println("no employees found");
            testdata();
        }

        System.out.println("Application Booted Successfully:");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void testdata(){
        employeeDao.addEmployee(new Employee("Jack", Gender.MALE));
        employeeDao.addEmployee(new Employee( "Chloe", Gender.FEMALE));
        employeeDao.addEmployee(new Employee( "Kim", Gender.FEMALE));
        employeeDao.addEmployee(new Employee( "David", Gender.MALE));
        employeeDao.addEmployee(new Employee( "Michelle", Gender.FEMALE));
    }
}