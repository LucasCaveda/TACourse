package com.solvd.computerShop.person;

import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.interfaces.IEmployee;
import com.solvd.computerShop.exceptions.InvalidEmployeeId;
import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;


public class Employee extends Person implements IEmployee {
    private int employeeId;
    private int salary;
    private boolean working;

    public Employee(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType, int employeeId, int salary, boolean working) {
        super(firstName, lastName, dni, age, genderType);
        if(employeeId>0){
            this.employeeId = employeeId;
        }else throw new InvalidEmployeeId();
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
    public void working(){
        if (working){
            LOGGER1.debug(getFirstName()+" is working.");
        }
    }

}
