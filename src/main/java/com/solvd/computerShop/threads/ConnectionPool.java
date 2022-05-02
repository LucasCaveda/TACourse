package com.solvd.computerShop.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConnectionPool {
    private final int limitConnections;
    private final Map<String, Connection> concurrentMap;
    private static ConnectionPool instance;

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class.getName());

    //Singleton
    private ConnectionPool(int limitThreads) {
        this.limitConnections = limitThreads;
        this.concurrentMap = new ConcurrentHashMap<String, Connection>();

    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(4);
        }
        return instance;
    }

    public synchronized Connection connect(String name) {
        Connection connection = new Connection(name);
        if (concurrentMap.size() < limitConnections) {
            concurrentMap.put(name, connection);
        }
        return connection;
    }

    public Boolean isFull() {
        return getConcurrentMapSize() >= limitConnections;
    }

    public int getConcurrentMapSize() {
        return concurrentMap.size();
    }

    public synchronized void disconnect(String name) {
        LOGGER.debug("Connection finished value: " + name);
        concurrentMap.remove(name);
        //remove the connection value on the map and one available connection will be appeared.
    }
}
