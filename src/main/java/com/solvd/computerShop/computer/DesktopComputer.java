package com.solvd.computerShop.computer;

import com.solvd.computerShop.peripheral.Peripheral;

import java.util.HashSet;

public class DesktopComputer extends Computer{
    private HashSet<Peripheral> peripherals;

    public DesktopComputer(ComputerComponent CPU, ComputerComponent GPU, ComputerComponent memory, ComputerComponent storage, String brand, HashSet<Peripheral> peripherals) {
        super(CPU, GPU, memory, storage, brand);
        this.peripherals = peripherals;
    }

    public static DesktopComputer createDesktopComputer() {
        ComputerComponent CPU = new ComputerComponent(false, "Ryzen 7");
        ComputerComponent GPU = new ComputerComponent(true, "RX5500XT");
        ComputerComponent memory = new ComputerComponent(false, "16gb Teamgroup");
        ComputerComponent storage = new ComputerComponent(true, "1tb Seagate");
        return new DesktopComputer(CPU, GPU, memory, storage, null, null);
    }

    public HashSet<Peripheral> getPeripherals() {return peripherals;}

    public void setPeripherals(HashSet<Peripheral> peripherals) {
        this.peripherals = peripherals;
    }
}