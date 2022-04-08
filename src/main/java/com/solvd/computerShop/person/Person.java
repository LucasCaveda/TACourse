package com.solvd.computerShop.person;

import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.interfaces.IPerson;
import com.solvd.computerShop.exceptions.InvalidDni;
import com.solvd.computerShop.exceptions.InvalidWord;
import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;


import static com.solvd.computerShop.validationFunctions.Validations.*;

public abstract class Person implements IPerson {
    private Enum <GenderType> genderType;
    private String firstName;
    private String lastName;
    private String dni;
    private int age;

    public Person(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType) {
        try {
            if(checkWord(firstName)){
                this.firstName = firstName;
            }
        } catch (InvalidWord e) {
            e.getMessage();
        }
        try {
            if(checkWord(lastName)){
                this.lastName = lastName;
            }
        } catch (InvalidWord e) {
            e.getMessage();
        }
        this.genderType = genderType;
        if (checkAge(age)){
            this.age = age;
        }
        try {
            if (checkDni(dni)){
                this.dni = dni;
            }
        } catch (InvalidDni e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sayHello(String firstName){
        LOGGER1.debug("Hello, my name is "+firstName+".");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Enum<GenderType> getGenderType() {
        return genderType;
    }

    public void setGenderType(Enum<GenderType> genderType) {
        this.genderType = genderType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
