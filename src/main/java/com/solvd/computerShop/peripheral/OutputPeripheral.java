package com.solvd.computerShop.peripheral;

public class OutputPeripheral extends Peripheral{
    private Boolean switchedOn;

    public OutputPeripheral(String connection, Boolean switchedOn) {
        super(connection);
        this.switchedOn = switchedOn;
    }

    public Boolean getSwitchedOn() {
        return switchedOn;
    }

    public void setSwitchedOn(Boolean switchedOn) {
        this.switchedOn = switchedOn;
    }
}
