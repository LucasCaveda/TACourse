package com.solvd.computerShop.computer;


import com.solvd.computerShop.peripheral.Peripheral;

import java.util.HashSet;

public class Laptop extends Computer{
    private ComputerComponent screen;
    private ComputerComponent keyboard;
    private HashSet<Peripheral> peripherals;

    public Laptop(ComputerComponent CPU, ComputerComponent GPU, ComputerComponent memory, ComputerComponent storage, String brand, ComputerComponent screen, ComputerComponent keyboard, HashSet<Peripheral> peripherals) {
        super(CPU, GPU, memory, storage, brand);
        this.screen = screen;
        this.keyboard = keyboard;
        this.peripherals = peripherals;
    }

    public static Laptop createLaptop() {
        ComputerComponent CPU = new ComputerComponent(false, "Core I7");
        ComputerComponent GPU = new ComputerComponent(false, "Intel Graphics");
        ComputerComponent memory = new ComputerComponent(true, "16 gb acer");
        ComputerComponent storage = new ComputerComponent(false, "500gb");
        ComputerComponent screen = new ComputerComponent(false, "Oled");
        ComputerComponent keyboard = new ComputerComponent(true, "tkl");

        return new Laptop(CPU, GPU, memory, storage, "Acer", screen, keyboard, null);
    }

    public ComputerComponent getScreen() {
        return screen;
    }

    public void setScreen(ComputerComponent screen) {
        this.screen = screen;
    }

    public ComputerComponent getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(ComputerComponent keyboard) {
        this.keyboard = keyboard;
    }

    public HashSet<Peripheral> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(HashSet<Peripheral> peripherals) {
        this.peripherals = peripherals;
    }
}
