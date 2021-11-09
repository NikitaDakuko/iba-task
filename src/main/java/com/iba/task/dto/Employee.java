package com.iba.task.dto;

public class Employee {
    private Long employeeId;
    private String firstName;
    private Gender gender;

    public Employee(long employeeId, String firstName, Gender gender){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.gender = gender;
    }

    public Employee(String jack, Gender male) {
        this.firstName = jack;
        this.gender = male;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
