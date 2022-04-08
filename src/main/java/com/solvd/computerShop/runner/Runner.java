package com.solvd.computerShop.runner;

import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.exceptions.InvalidWorkingStatus;
import com.solvd.computerShop.computer.ComputerComponent;
import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.person.Employee;
import com.solvd.computerShop.shop.WorkingSpaces;
import com.solvd.computerShop.tool.Tool;
import com.solvd.computerShop.peripheral.InputPeripheral;
import com.solvd.computerShop.peripheral.OutputPeripheral;
import com.solvd.computerShop.peripheral.Peripheral;
import com.solvd.computerShop.person.Client;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;
import com.solvd.computerShop.shop.ComputerRepairShop;

import java.util.*;

import static com.solvd.computerShop.computer.DesktopComputer.createDesktopComputer;
import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;


public class Runner {/*

    public static void main(String[] args) throws InvalidWorkingStatus {
        Collection<Tool> toolsSet = null;


        Client client1 = new Client("Carlos", "Perez", "32415142", 'M', 31, desktopComputer);
        Client client2 = new Client("Juan", "Marozzi", "40412423", 'M', 24, laptop);
        RepairEmployee employee1 = new RepairEmployee("Gerardo", "Ramirez", "39123921", 'M', 25, 0002, true, 1500, 1, toolsSet, true);
        RepairEmployee employee2 = new RepairEmployee("Mavel", "Urquiza", "33324531", 'F', 35, 0003, false, 1500, 1, toolsSet, true);
        RepairEmployee employee3 = new RepairEmployee("Oscar", "Galatea", "42416473", 'M', 22, 0004, true, 1500, 1, toolsSet, true);
        RepairEmployee employee4 = new RepairEmployee("Sebastian", "Guarnizo", "39123921", 'M', 25, 0005, false, 1500, 1, toolsSet, true);
        Tool screwdriver = new Tool("tighten and loosen screws");
        Tool welder = new Tool("merge wires");
        Tool gripper = new Tool("cut wires");
        ManagerEmployee manager = new ManagerEmployee("Florencia", "Salvador", "33415678", 'F', 34, 0001, true, 3000, true);

        //I replaced the employee array with a HashSet
        GenericLinkedList<RepairEmployee> employees = new GenericLinkedList<>();

        WorkingSpaces workingSpaces = new WorkingSpaces(4, 4);

        assignSpace(workingSpaces,employees,employee1,1);
        assignSpace(workingSpaces,employees,employee2,2);
        assignSpace(workingSpaces,employees,employee3,3);
        assignSpace(workingSpaces,employees,employee4,4);
        assignSpace(workingSpaces,employees,employee4,5);

        toolsSet = new ArrayList<>();
        toolsSet.add(screwdriver);
        toolsSet.add(welder);
        toolsSet.add(gripper);


        //ComputerRepairShop computerRepairShop = new ComputerRepairShop("Computer service", "Estrada 1455", manager, employees, workSpaces);

        Queue<Client> clientQueue = new LinkedList<>();
        clientQueue.add(client1);
        clientQueue.add(client2);

        client1.sayHello(client1.getFirstName());
        if (employee1.isWorking()) {
            employee1.working();
            employee1.repair(laptop, clientQueue);
            employee1.cleanComputer();
        } else throw new InvalidWorkingStatus();
        manager.collectRepair();
    }

    public static void assignSpace(WorkingSpaces workingSpaces, GenericLinkedList<RepairEmployee> employees, RepairEmployee employee, int space) {
        if(workingSpaces.getUnassignedSpaces()>0)
            employees.insertAt(space, employee);
        else
            LOGGER1.info("No more working spaces available");
    }





*/
}
