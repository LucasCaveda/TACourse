package com.solvd.computerShop.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SimpleRunnable implements Runnable {
    public String name;

    private static final Logger LOGGER = LogManager.getLogger(SimpleRunnable.class.getName());

    public SimpleRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Client.createConnection(this.name);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }
}
