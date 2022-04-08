package com.solvd.computerShop.shop;

import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.person.Employee;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;

import java.util.Set;

public class ComputerRepairShop extends Shop{
    private ManagerEmployee manager;
    private GenericLinkedList<RepairEmployee> repairEmployees;
    private WorkingSpaces workingSpaces;


    public ComputerRepairShop(String name, String address, ManagerEmployee manager, GenericLinkedList<RepairEmployee> repairEmployees, WorkingSpaces workingSpaces) {
        super(name, address);
        this.manager = manager;
        this.repairEmployees = repairEmployees;
        this.workingSpaces = workingSpaces;
    }

    public ManagerEmployee getManager() {
        return manager;
    }

    public void setManager(ManagerEmployee manager) {
        this.manager = manager;
    }

    public GenericLinkedList<RepairEmployee> getRepairEmployees() {
        return repairEmployees;
    }

    public void setRepairEmployees(GenericLinkedList<RepairEmployee> repairEmployees) {
        this.repairEmployees = repairEmployees;
    }

    public WorkingSpaces getWorkingSpaces() {
        return workingSpaces;
    }

    public void setWorkingSpaces(WorkingSpaces workingSpaces) {
        this.workingSpaces = workingSpaces;
    }
}
