package com.solvd.computerShop.threads;

import com.solvd.computerShop.exceptions.ConnectionLimitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Client {

    //threads which use connection pool and call connect method
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(Client.class.getName());

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        //Adding 2 simple threads
//        threads.add(new SimpleThread("Simple Thread: 1"));
//        threads.add(new SimpleThread("Simple Thread: 2"));
        for (int i = 0; i < 7; i++) {
            //Adding 5 runnable threads
            threads.add(new Thread(new SimpleRunnable("Runnable Thread: " + i)));
        }
        for (Thread t : threads) {
            Thread.sleep(400);
            while (connectionPool.isFull()) {
                LOGGER.debug("!!!!!!!Thread limit: thread is waiting: " + t.getName());
                t.join();
            }
            t.start();
        }
    }

    public static void createConnection(String name) throws ConnectionLimitException, InterruptedException {

        Connection connection = connectionPool.connect(name);

        Thread.sleep(5000);

        connectionPool.disconnect(name);


    }
}
