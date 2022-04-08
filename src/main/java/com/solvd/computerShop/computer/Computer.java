package com.solvd.computerShop.computer;

public abstract class Computer {
    private ComputerComponent CPU;
    private ComputerComponent GPU;
    private ComputerComponent memory;
    private ComputerComponent storage;
    private String brand;

    public Computer(ComputerComponent CPU, ComputerComponent GPU, ComputerComponent memory, ComputerComponent storage, String brand) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.memory = memory;
        this.storage = storage;
        this.brand = brand;
    }

    public ComputerComponent getCPU() {
        return CPU;
    }

    public void setCPU(ComputerComponent CPU) {
        this.CPU = CPU;
    }

    public ComputerComponent getGPU() {
        return GPU;
    }

    public void setGPU(ComputerComponent GPU) {
        this.GPU = GPU;
    }

    public ComputerComponent getMemory() {
        return memory;
    }

    public void setMemory(ComputerComponent memory) {
        this.memory = memory;
    }

    public ComputerComponent getStorage() {
        return storage;
    }

    public void setStorage(ComputerComponent storage) {
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
