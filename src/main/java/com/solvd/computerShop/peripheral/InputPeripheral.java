package com.solvd.computerShop.peripheral;

public class InputPeripheral extends Peripheral{
    private Boolean switchedOn;

    public InputPeripheral(String connection, Boolean switchedOn) {
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
