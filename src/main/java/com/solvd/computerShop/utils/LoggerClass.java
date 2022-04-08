package com.solvd.computerShop.utils;

import com.solvd.computerShop.person.RepairEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    public static final Logger LOGGER1 = LogManager.getLogger(RepairEmployee.class.getName());

}