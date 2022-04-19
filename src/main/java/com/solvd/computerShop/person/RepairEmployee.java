package com.solvd.computerShop.person;

import com.solvd.computerShop.computer.AllInOneComputer;
import com.solvd.computerShop.computer.Computer;
import com.solvd.computerShop.computer.DesktopComputer;
import com.solvd.computerShop.computer.Laptop;
import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.interfaces.CleanProcessor;
import com.solvd.computerShop.tool.Tool;
import com.solvd.computerShop.interfaces.ICleanComputer;
import com.solvd.computerShop.interfaces.IComputerRepair;
import com.solvd.computerShop.exceptions.InvalidWorkingStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Queue;


public class RepairEmployee extends Employee implements IComputerRepair, ICleanComputer {
    private int taskQueue;
    private Collection<Tool> tools;
    private Boolean repairing;

    private static final Logger LOGGER1 = LogManager.getLogger(RepairEmployee.class.getName());

    public RepairEmployee(String firstName, String lastName, String dni, int age, Enum<GenderType> genderType, int employeeId, int salary, boolean working, int taskQueue, Collection<Tool> tools, Boolean repairing) {
        super(firstName, lastName, dni, age, genderType, employeeId, salary, working);
        this.taskQueue = taskQueue;
        this.tools = tools;
        this.repairing = repairing;
    }

    public int getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(int taskQueue) {
        this.taskQueue = taskQueue;
    }

    public Collection<Tool> getTools() {
        return tools;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    public Boolean getRepairing() {
        return repairing;
    }

    public void setRepairing(Boolean repairing) {
        this.repairing = repairing;
    }

    @Override
    public void repair(Computer computer, Queue<Client> clientQueue) throws InvalidWorkingStatus {
        for (Client client : clientQueue) {
            LOGGER1.debug("The client " + client.getFirstName() + " delivered a/an " + computer.getBrand() + " brand computer");
            diagnosis(computer);
            if (this.isWorking()) {
                LOGGER1.debug("The " + client.getFirstName() + "'s computer is being repaired by " + this.getFirstName());
            } else {
                throw new InvalidWorkingStatus();
            }
        }
    }

    @Override
    public void diagnosis(Computer computer) {
        int repairCost = 0;
        if (computer instanceof DesktopComputer) {
            LOGGER1.debug("Computer diagnosis:");
            if (computer.getCPU().isStatus() && computer.getGPU().isStatus() && computer.getMemory().isStatus() && computer.getStorage().isStatus()) {
                LOGGER1.debug("       CPU status: working");
                LOGGER1.debug("       GPU status: working");
                LOGGER1.debug("       memory status: working");
                LOGGER1.debug("       storage status: working");
                LOGGER1.debug("\nAll components of the computer work properly, the computer is not broken.");
            } else if (!computer.getCPU().isStatus()) {
                LOGGER1.debug("       CPU status: broken");
                repairCost = repairCost + 1000;
            }
            if (!computer.getGPU().isStatus()) {
                LOGGER1.debug("       GPU status: broken");
                repairCost = repairCost + 1200;
            }
            if (!computer.getMemory().isStatus()) {
                LOGGER1.debug("       memory status: broken");
                repairCost = repairCost + 500;
            }
            if (!computer.getStorage().isStatus()) {
                LOGGER1.debug("       storage status: broken");
                repairCost = repairCost + 250;
            }
        } else if (computer instanceof Laptop) {
            LOGGER1.debug("Computer diagnosis:");
            if (computer.getCPU().isStatus() && computer.getGPU().isStatus() && computer.getMemory().isStatus() && computer.getStorage().isStatus() && ((Laptop) computer).getScreen().isStatus() && ((Laptop) computer).getKeyboard().isStatus()) {
                LOGGER1.debug("       CPU status: working");
                LOGGER1.debug("       GPU status: working");
                LOGGER1.debug("       memory status: working");
                LOGGER1.debug("       storage status: working");
                LOGGER1.debug("       screen status: working");
                LOGGER1.debug("       keyboard status: working");
                LOGGER1.debug("\nAll components of the computer work properly, the computer is not broken.");
            } else if (!computer.getCPU().isStatus()) {
                LOGGER1.debug("       CPU status: broken");
                repairCost = repairCost + 1000;
            }
            if (!computer.getGPU().isStatus()) {
                LOGGER1.debug("       GPU status: broken");
                repairCost = repairCost + 1200;
            }
            if (!computer.getMemory().isStatus()) {
                LOGGER1.debug("       memory status: broken");
                repairCost = repairCost + 500;
            }
            if (!computer.getStorage().isStatus()) {
                LOGGER1.debug("       storage status: broken");
                repairCost = repairCost + 250;
            }
            if (!((Laptop) computer).getScreen().isStatus()) {
                LOGGER1.debug("       screen status: broken");
                repairCost = repairCost + 500;
            }
            if (!((Laptop) computer).getKeyboard().isStatus()) {
                LOGGER1.debug("       keyboard status: broken");
                repairCost = repairCost + 350;
            }
        } else if (computer instanceof AllInOneComputer) {
            LOGGER1.debug("\nComputer diagnosis:\n");
            if (computer.getCPU().isStatus() && computer.getGPU().isStatus() && computer.getMemory().isStatus() && computer.getStorage().isStatus() && ((AllInOneComputer) computer).getScreen().isStatus()) {
                LOGGER1.debug("       CPU status: working");
                LOGGER1.debug("       GPU status: working");
                LOGGER1.debug("       memory status: working");
                LOGGER1.debug("       storage status: working");
                LOGGER1.debug("       screen status: working");
                LOGGER1.debug("\nAll components of the computer work properly, the computer is not broken.");
            } else if (!computer.getCPU().isStatus()) {
                LOGGER1.debug("       CPU status: broken");
                repairCost = repairCost + 1000;
            }
            if (!computer.getGPU().isStatus()) {
                LOGGER1.debug("       GPU status: broken");
                repairCost = repairCost + 1200;
            }
            if (!computer.getMemory().isStatus()) {
                LOGGER1.debug("       memory status: broken");
                repairCost = repairCost + 500;
            }
            if (!computer.getStorage().isStatus()) {
                LOGGER1.debug("       storage status: broken");
                repairCost = repairCost + 250;
            }
            if (!((AllInOneComputer) computer).getScreen().isStatus()) {
                LOGGER1.debug("       screen status: broken");
                repairCost = repairCost + 500;
            }
        }
        LOGGER1.debug("\nThe repair cost will be $" + repairCost + "\n");
    }

    @Override
    public void cleanComputer() {
        LOGGER1.debug(this.getFirstName() + "has cleaned the computer.");
    }

    public float clean(float time, CleanProcessor cleanProcessor){
        float price = cleanProcessor.clean(time);
        return price;
    }
}


