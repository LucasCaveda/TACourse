package com.solvd.computerShop.exceptions;

public class InvalidWorkingStatus extends Exception {
    @Override
    public String getMessage() {
        return "The employee is not working.";
    }
}
