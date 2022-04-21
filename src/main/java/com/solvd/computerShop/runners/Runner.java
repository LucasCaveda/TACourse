package com.solvd.computerShop.runners;

import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.exceptions.InvalidWorkingStatus;
import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.shop.WorkingSpaces;
import com.solvd.computerShop.tool.Tool;
import com.solvd.computerShop.person.Client;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;
import com.solvd.computerShop.shop.ComputerRepairShop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.solvd.computerShop.computer.DesktopComputer.createDesktopComputer;
import static com.solvd.computerShop.computer.Laptop.createLaptop;


public class Runner {

    private static final Logger LOGGER1 = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) throws InvalidWorkingStatus {

        Collection<Tool> toolsSet = null;
        DesktopComputer desktopComputer = createDesktopComputer();
        Laptop laptop = createLaptop();

        Client client1 = new Client("Carlos", "Perez", "32415142", 31, GenderType.MALE, desktopComputer);
        Client client2 = new Client("Juan", "Marozzi", "40412423", 24, GenderType.MALE, laptop);
        RepairEmployee employee1 = new RepairEmployee("Gerardo", "Ramirez", "39123921", 24, GenderType.MALE, 0002, 1500, true, 1, toolsSet, true);
        RepairEmployee employee2 = new RepairEmployee("Mabel", "Urquiza", "33324531", 32, GenderType.FEMALE, 0005, 1500,false, 1, null, false);
        RepairEmployee employee3 = new RepairEmployee("Oscar", "Galatea", "42416473", 22, GenderType.MALE, 0003, 1500, true, 1, toolsSet, true);
        RepairEmployee employee4 = new RepairEmployee("Sebastian", "Guarnizo", "39123921", 25, GenderType.MALE, 0004,1500, false, 1, null, false);
        ManagerEmployee manager = new ManagerEmployee("Florencia", "Salvador", "33415678", 33, GenderType.FEMALE, 0001, 3000, true, true);
        Tool screwdriver = new Tool("tighten and loosen screws");
        Tool welder = new Tool("merge wires");
        Tool gripper = new Tool("cut wires");

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


        //ComputerRepairShop computerRepairShop = new ComputerRepairShop("Computer service", "Estrada 1455", manager, employees, workingSpaces);

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






}
