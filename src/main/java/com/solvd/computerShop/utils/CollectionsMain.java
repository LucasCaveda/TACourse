package com.solvd.computerShop.utils;

import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.peripheral.InputPeripheral;
import com.solvd.computerShop.peripheral.OutputPeripheral;
import com.solvd.computerShop.peripheral.Peripheral;
import com.solvd.computerShop.person.Client;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;
import com.solvd.computerShop.shop.ComputerRepairShop;
import com.solvd.computerShop.shop.WorkingSpaces;
import com.solvd.computerShop.tool.Tool;

import java.util.*;

import static com.solvd.computerShop.computer.DesktopComputer.createDesktopComputer;
import static com.solvd.computerShop.computer.Laptop.createLaptop;
import static com.solvd.computerShop.utils.LoggerClass.LOGGER1;

public class CollectionsMain {
    public static void main(String[] args) {

        DesktopComputer desktopComputer = createDesktopComputer();
        Laptop laptop = createLaptop();

        // 1. HashSet
        //      Creating a HashSet of peripherals

        HashSet<Peripheral> peripheralsSet = new HashSet<>();

        InputPeripheral mouse = new InputPeripheral("bluetooth", true);
        InputPeripheral keyboard = new InputPeripheral("usb", true);
        OutputPeripheral screen = new OutputPeripheral("hdmi", false);

        peripheralsSet.add(mouse);
        peripheralsSet.add(keyboard);
        peripheralsSet.add(screen);

        desktopComputer.setPeripherals(peripheralsSet);

        // 2. ArrayList
        //      Creating a ArrayList of tools

        Tool screwdriver = new Tool("tighten and loosen screws");
        Tool welder = new Tool("merge wires");
        Tool gripper = new Tool("cut wires");

        Collection<Tool> toolsSet = new ArrayList<>();
        toolsSet.add(screwdriver);
        toolsSet.add(welder);
        toolsSet.add(gripper);

        // 3. LinkedList
        //      Creating a LinkedList of clients

        Client client1 = new Client("Carlos", "Perez", "32415142", 31, GenderType.MALE, desktopComputer);
        Client client2 = new Client("Juan", "Marozzi", "40412423", 24, GenderType.MALE, laptop);

        Queue<Client> clientQueue = new LinkedList<>();
        clientQueue.add(client1);
        clientQueue.add(client2);

        // 4. Custom GenericLinkedList
        //      Creating a GenericLinkedList of employees.

        RepairEmployee employee1 = new RepairEmployee("Gerardo", "Ramirez", "39123921", 24, GenderType.MALE, 0002, 1500, true, 1, toolsSet, true);
        RepairEmployee employee2 = new RepairEmployee("Mabel", "Urquiza", "33324531", 32, GenderType.FEMALE, 0005, 1500,false, 1, null, false);
        RepairEmployee employee3 = new RepairEmployee("Oscar", "Galatea", "42416473", 22, GenderType.MALE, 0003, 1500, true, 1, toolsSet, true);
        RepairEmployee employee4 = new RepairEmployee("Sebastian", "Guarnizo", "39123921", 25, GenderType.MALE, 0004,1500, false, 1, null, false);
        ManagerEmployee manager = new ManagerEmployee("Florencia", "Salvador", "33415678", 33, GenderType.FEMALE, 0001, 3000, true, true);


        GenericLinkedList<RepairEmployee> employees = new GenericLinkedList<>();

        WorkingSpaces workingSpaces = new WorkingSpaces(4, 4);


        assignSpace(workingSpaces, employees, employee1, 0);
        assignSpace(workingSpaces, employees, employee2, 1);
        assignSpace(workingSpaces, employees, employee3, 2);
        assignSpace(workingSpaces, employees, employee4, 3);
        assignSpace(workingSpaces,employees,employee4,5);

        //Creating a ComputerRepairShop

        ComputerRepairShop computerRepairShop = new ComputerRepairShop("Computer service", "Estrada 1455", manager, employees, workingSpaces);
    }

    public static void assignSpace(WorkingSpaces workingSpaces, GenericLinkedList<RepairEmployee> employees, RepairEmployee employee, int space) {
        if (workingSpaces.getUnassignedSpaces() > 0){
            employees.insertAt(space,employee);
            workingSpaces.setUnassignedSpaces(workingSpaces.getUnassignedSpaces()-1);}
        else LOGGER1.info("No more working spaces available");
    }
}