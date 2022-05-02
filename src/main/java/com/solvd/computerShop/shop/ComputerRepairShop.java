package com.solvd.computerShop.shop;

import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.interfaces.WaitTimeProcessor;
import com.solvd.computerShop.person.Employee;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;

import java.util.ArrayList;

public class ComputerRepairShop extends Shop{
    private ManagerEmployee manager;
    private ArrayList<RepairEmployee> repairEmployees;
    private WorkingSpaces workingSpaces;


    public ComputerRepairShop(String name, String address, ManagerEmployee manager, ArrayList<RepairEmployee> repairEmployees, WorkingSpaces workingSpaces) {
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

    public ArrayList<RepairEmployee> getRepairEmployees() {
        return repairEmployees;
    }

    public void setRepairEmployees(ArrayList<RepairEmployee> repairEmployees) {
        this.repairEmployees = repairEmployees;
    }

    public WorkingSpaces getWorkingSpaces() {
        return workingSpaces;
    }

    public void setWorkingSpaces(WorkingSpaces workingSpaces) {
        this.workingSpaces = workingSpaces;
    }

    public ArrayList<Employee> getListEmployeesWorking(){
        ArrayList<Employee> repairEmployeesWorking = new ArrayList<>();
        for (RepairEmployee r: repairEmployees) {
            if (r.isWorking()) {
                repairEmployeesWorking.add(r);
            }
        }
        return repairEmployeesWorking;
    }
}
