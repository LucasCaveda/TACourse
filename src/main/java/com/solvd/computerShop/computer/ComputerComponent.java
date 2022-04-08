package com.solvd.computerShop.computer;

public class ComputerComponent {
    private boolean status;         // true=working | false=broken
    private String name;

    public ComputerComponent(boolean status, String name) {
        this.status = status;
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
