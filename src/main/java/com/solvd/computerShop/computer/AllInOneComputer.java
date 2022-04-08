package com.solvd.computerShop.computer;


import com.solvd.computerShop.peripheral.Peripheral;


import java.util.HashSet;


public class AllInOneComputer extends Computer{
    private ComputerComponent screen;
    private HashSet<Peripheral> peripherals;

    public AllInOneComputer(ComputerComponent CPU, ComputerComponent GPU, ComputerComponent memory, ComputerComponent storage, String brand, ComputerComponent screen, HashSet<Peripheral> peripherals) {
        super(CPU, GPU, memory, storage, brand);
        this.screen = screen;
        this.peripherals = peripherals;
    }
    public ComputerComponent getScreen() {
        return screen;
    }

    public void setScreen(ComputerComponent screen) {
        this.screen = screen;
    }

    public HashSet<Peripheral> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(HashSet<Peripheral> peripherals) {
        this.peripherals = peripherals;
    }
}
