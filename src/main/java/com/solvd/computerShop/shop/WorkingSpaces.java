package com.solvd.computerShop.shop;


public class WorkingSpaces {
    private int maxSpaces;
    private int unassignedSpaces;

    public WorkingSpaces(int maxSpaces, int unassignedSpaces) {
        this.maxSpaces = maxSpaces;
        this.unassignedSpaces = unassignedSpaces;
    }

    public int getMaxSpaces() {
        return maxSpaces;
    }

    public void setMaxSpaces(int maxSpaces) {
        this.maxSpaces = maxSpaces;
    }

    public int getUnassignedSpaces() {
        return unassignedSpaces;
    }

    public void setUnassignedSpaces(int unassignedSpaces) {
        this.unassignedSpaces = unassignedSpaces;
    }
}
