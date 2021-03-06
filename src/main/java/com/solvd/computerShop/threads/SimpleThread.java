package com.solvd.computerShop.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SimpleThread extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(SimpleThread.class.getName());

    public SimpleThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        try {
            Client.createConnection(this.getName());
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
