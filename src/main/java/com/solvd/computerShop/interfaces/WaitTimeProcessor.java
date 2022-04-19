package com.solvd.computerShop.interfaces;

@FunctionalInterface
public interface WaitTimeProcessor {
    public abstract float waitTime(int queueSize);
}
