package com.solvd.computerShop.exceptions;

public class InvalidWord extends RuntimeException{
    @Override
    public String getMessage() {
        return "The word cannot have numbers.";
    }
}
