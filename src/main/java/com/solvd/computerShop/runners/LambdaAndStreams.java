package com.solvd.computerShop.runners;

import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.generics.GenericLinkedList;
import com.solvd.computerShop.person.Client;
import com.solvd.computerShop.person.ManagerEmployee;
import com.solvd.computerShop.person.RepairEmployee;
import com.solvd.computerShop.shop.ComputerRepairShop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static com.solvd.computerShop.computer.DesktopComputer.createDesktopComputer;
import static com.solvd.computerShop.computer.Laptop.createLaptop;



public class LambdaAndStreams {

    private static final Logger LOGGER1 = LogManager.getLogger(LambdaAndStreams.class.getName());

    public static void main(String[] args) {

        DesktopComputer desktopComputer = createDesktopComputer();
        Laptop laptop = createLaptop();

        Client client1 = new Client("Carlos", "Perez", "32415142", 31, GenderType.MALE, desktopComputer);
        Client client2 = new Client("Juan", "Marozzi", "40412423", 24, GenderType.MALE, laptop);

        Queue<Client> clientQueue = new LinkedList<>();
        clientQueue.add(client1);
        clientQueue.add(client2);

        RepairEmployee employee1 = new RepairEmployee("Gerardo", "Ramirez", "39123921", 24, GenderType.MALE, 0002, 1500, true, 1, null, true);
        RepairEmployee employee2 = new RepairEmployee("Mabel", "Urquiza", "33324531", 32, GenderType.FEMALE, 0005, 1500, false, 1, null, false);
        RepairEmployee employee3 = new RepairEmployee("Oscar", "Galatea", "42416473", 22, GenderType.MALE, 0003, 1500, true, 1, null, true);
        RepairEmployee employee4 = new RepairEmployee("Sebastian", "Guarnizo", "39123921", 25, GenderType.MALE, 0004, 1500, false, 1, null, false);
        ManagerEmployee manager = new ManagerEmployee("Florencia", "Salvador", "33415678", 33, GenderType.FEMALE, 0001, 3000, true, true);

        GenericLinkedList<RepairEmployee> employees = new GenericLinkedList<>();

        ComputerRepairShop computerRepairShop = new ComputerRepairShop("Computer service", "Estrada 1455", manager, employees, null);

        //Using lambda functions for functional interfaces
        for(int i=0;i<clientQueue.size();i++){
            //Price will be different depending on the time used for clean the computer.
            LOGGER1.debug("The price of cleaning is $"+
                    employee1.clean(1.3f + (float) i, (time -> 2 * time)));
        }


        for (int i=0;i<clientQueue.size();i++){
            //Calculating about 5 minutes per client
            LOGGER1.debug("The wait time is about " + computerRepairShop.waitTime(clientQueue.size(),i,( queueSize -> 5* clientQueue.size())));
            clientQueue.remove();
        }

        //Stream implementation is not ready yet


        }
}
