package com.solvd.computerShop.generics;

public class Node <T>{
    T data; //Data in the current node
    Node<T> next; //Reference for the next node

    Node(T data) {
        this.data = data;
    }
}
