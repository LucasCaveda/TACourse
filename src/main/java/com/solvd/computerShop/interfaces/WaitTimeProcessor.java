package com.solvd.computerShop.interfaces;

@FunctionalInterface
public interface WaitTimeProcessor {
    void waitTime(int queueSize, int time);
}
