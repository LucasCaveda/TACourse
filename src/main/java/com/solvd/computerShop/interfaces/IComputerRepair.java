package com.solvd.computerShop.interfaces;

import com.solvd.computerShop.person.Client;
import com.solvd.computerShop.computer.Computer;
import com.solvd.computerShop.exceptions.InvalidWorkingStatus;

import java.util.Queue;

public interface IComputerRepair {
    void repair(Computer computer, Queue<Client> clientQueue) throws InvalidWorkingStatus;
    void diagnosis(Computer computer);
}
