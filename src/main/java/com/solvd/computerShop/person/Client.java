package com.solvd.computerShop.person;

import com.solvd.computerShop.computer.Computer;
import com.solvd.computerShop.enums.GenderType;

public class Client extends Person {
    private Computer computer;

    public Client(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType, Computer computer) {
        super(firstName, lastName, dni, age, genderType);
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
