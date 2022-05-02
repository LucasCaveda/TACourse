package com.solvd.computerShop.exceptions;

public class InvalidWorkingStatus extends RuntimeException {
    @Override
    public String getMessage() {
        return "The employee is not working.";
    }
}
