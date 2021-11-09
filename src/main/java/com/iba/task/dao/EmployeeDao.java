package com.iba.task.dao;

import com.iba.task.dto.Employee;
import com.iba.task.dto.Gender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao{

    final
    JdbcTemplate jdbcTemplate;

    private final List<Employee> employees;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        employees = jdbcTemplate.query(
                "SELECT * FROM EMPLOYEE",
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("first_name"),
                                Gender.valueOf(rs.getString("gender"))
                        )
                 );
    }

    public List<Employee> getAllEmployees() {
        return this.employees;
    }

    public void addEmployee(Employee emp) {
        jdbcTemplate.update(
                "INSERT INTO EMPLOYEE (first_name, gender)" +
                    " VALUES (?, ?)",
                    emp.getFirstName(), emp.getGender().toString()
        );

        employees.add(emp);
    }

    public void deleteEmployee(long employeeId){
        jdbcTemplate.update(
                "DELETE FROM employee " +
                    " WHERE employee_id = " + employeeId
        );

        employees.removeIf(x -> x.getEmployeeId() == employeeId);

        System.out.println("deleted employee id:" + employeeId);
    }

    public Employee getEmployeeByID(Long id){
        return employees.get(Math.toIntExact(id));
    }

    public void updateEmployee(long employeeId, Employee employee){
        jdbcTemplate.update(
                "UPDATE employee" +
                " SET first_name = " + employee.getFirstName() +
                ", gender = " + employee.getGender() +
                " WHERE employee_id = " + employeeId
        );

        employees.set(
                employees.indexOf(
                        employees.stream().filter(e -> e.getEmployeeId() == employeeId)
                        .findFirst()
                        .get()),
                employee
        );
    }
}
