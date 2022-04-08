package com.solvd.computerShop.person;

import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.interfaces.IManager;
import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;

public class ManagerEmployee extends Employee implements IManager {
    private Boolean supervising;

    public ManagerEmployee(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType, int employeeId, int salary, boolean working, Boolean supervising) {
        super(firstName, lastName, dni, age, genderType, employeeId, salary, working);
        this.supervising = supervising;
    }

    public Boolean getSupervising() {
        return supervising;
    }

    public void setSupervising(Boolean supervising) {
        this.supervising = supervising;
    }

    @Override
    public void collectRepair(){
        LOGGER1.debug("Thank you for trusting us, here's your change.");
    }

}

