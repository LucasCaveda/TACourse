package com.solvd.computerShop.exceptions;

public class InvalidEmployeeId extends RuntimeException{
    @Override
    public String getMessage() {
        return "Wrong employee ID - Input a valid ID";
    }
}
