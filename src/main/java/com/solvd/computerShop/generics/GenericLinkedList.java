package com.solvd.computerShop.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericLinkedList<T> {
    private Node<T> head;
    //This Generic class works with FIFO. First in first out

    private static final Logger LOGGER1 = LogManager.getLogger(GenericLinkedList.class.getName());

    //Insert at final of the queue
    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null)
            LOGGER1.debug("Linked list is empty");
        else
            head = head.next;
    }

    public int length() {
        Node<T> currentNode = head;
        int length = 0;
        if (currentNode == null) {
            return 0;
        } else {
            while (currentNode != null) {
                length++;
                currentNode = currentNode.next;
            }
            return length;
        }
    }

    public void insertAtStart(T data) {
        Node<T> newNode = new Node<T>(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, T data) {
        if (index == 0) {
            insertAtStart(data); //We already have a function to do this.
        } else {
            Node<T> newNode = new Node<T>(data);

            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public void show() {
        Node<T> currentNode = head;
        if (currentNode == null) {
            LOGGER1.debug("Linked list is empty");

        } else {
            while (currentNode != null) {
                LOGGER1.debug(currentNode.data + "; ");
                currentNode = currentNode.next;
            }
        }
    }
}
