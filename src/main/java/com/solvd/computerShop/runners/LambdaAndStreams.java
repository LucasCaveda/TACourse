package com.solvd.computerShop.runners;

import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.person.*;
import com.solvd.computerShop.shop.ComputerRepairShop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.solvd.computerShop.computer.DesktopComputer.createDesktopComputer;
import static com.solvd.computerShop.computer.Laptop.createLaptop;


public class LambdaAndStreams {

    private static final Logger LOGGER = LogManager.getLogger(LambdaAndStreams.class.getName());

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
        RepairEmployee employee3 = new RepairEmployee("Mariano", "Galatea", "42416473", 22, GenderType.MALE, 0003, 1500, true, 1, null, true);
        RepairEmployee employee4 = new RepairEmployee("Sebastian", "Guarnizo", "39123921", 25, GenderType.MALE, 0004, 1500, true, 1, null, false);
        ManagerEmployee manager = new ManagerEmployee("Florencia", "Salvador", "33415678", 33, GenderType.FEMALE, 0001, 3000, true, true);

        ArrayList<RepairEmployee> employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        ComputerRepairShop computerRepairShop = new ComputerRepairShop("Computer service", "Estrada 1455", manager, employees, null);


        IntStream.range(0, clientQueue.size()).forEach(i -> {
            //Price will be different depending on the time used for clean the computer.
            LOGGER.debug("The price of cleaning is $" +
                    employee1.clean(1.3f + (float) i, (time -> 2 * time)));
        });


        IntStream.range(0, clientQueue.size()).forEach(i -> {
            //Calculating about 5 minutes per client
            LOGGER.debug("The wait time is about " + computerRepairShop.waitTime(clientQueue.size(), i, (queueSize -> 5 * clientQueue.size())));
            clientQueue.remove();
        });

        //Stream implementation
        Stream<Employee> minAge = computerRepairShop.getListEmployeesWorking().stream();
        Stream<Employee> maxAge = computerRepairShop.getListEmployeesWorking().stream();
        Stream<Employee> countEmployees = computerRepairShop.getListEmployeesWorking().stream();
        Stream<Employee> filterStream = computerRepairShop.getListEmployeesWorking().stream();

        LOGGER.debug("The most young repairing employee working is" + minAge.min(Comparator.comparing(Employee::getAge)).map(Person::getFirstName));
        LOGGER.debug("The most older repairing employee working is" + maxAge.max(Comparator.comparing(Employee::getAge)).map(Person::getFirstName));
        LOGGER.debug("Count of elements: " + countEmployees.count());
        filterStream.filter(employee -> employee.getAge() < 25).map(Person::getFirstName).forEach(employee -> LOGGER.debug("The employees younger than 25 are: " + employee));

    }
}
