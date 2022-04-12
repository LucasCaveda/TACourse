package com.solvd.computerShop.peripheral;

import com.solvd.computerShop.enums.ConnectionType;
import com.solvd.computerShop.enums.PeripheralType;


public class Peripheral {
    private Enum <PeripheralType> peripheralType;
    private Enum <ConnectionType> connectionType;

    public Peripheral(Enum<PeripheralType> peripheralType, Enum<ConnectionType> connectionType) {
        this.peripheralType = peripheralType;
        this.connectionType = connectionType;
    }

    public Enum<PeripheralType> getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(Enum<PeripheralType> peripheralType) {
        this.peripheralType = peripheralType;
    }

    public Enum<ConnectionType> getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(Enum<ConnectionType> connectionType) {
        this.connectionType = connectionType;
    }
}

