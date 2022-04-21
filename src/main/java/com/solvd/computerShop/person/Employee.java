package com.solvd.computerShop.person;

import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.interfaces.IEmployee;
import com.solvd.computerShop.exceptions.InvalidEmployeeId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Employee extends Person implements IEmployee {
    private int employeeId;
    private int salary;
    private boolean working;

    private static final Logger LOGGER1 = LogManager.getLogger(Employee.class.getName());

    public Employee(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType, int employeeId, int salary, boolean working) {
        super(firstName, lastName, dni, age, genderType);
        if (employeeId > 0) {
            this.employeeId = employeeId;
        } else throw new InvalidEmployeeId();
        this.salary = salary;
        this.working = working;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public void working() {
        if (working) {
            LOGGER1.debug(getFirstName() + " is working.");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                ", working=" + working +
                '}';
    }
}
