package com.solvd.computerShop.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.logging.Level;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class.getName());

    public Connection(String name) {
        LOGGER.debug("New connection name: " + name);
    }

}
