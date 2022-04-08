package com.solvd.computerShop.peripheral;

import java.util.Collection;

public class Peripheral {
    private String connection;

    public Peripheral(String connection) {
        this.connection = connection;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}

