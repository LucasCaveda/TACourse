package com.solvd.computerShop.exceptions;

public class InvalidDni extends RuntimeException{
    @Override
    public String getMessage() {
        return "Wrong DNI. It must have 7 or 8 numbers";
    }
}
