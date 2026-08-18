package com.devtalles.proyect.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Queue<T> {
    private final LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element) {
        elements.addLast(element);

        System.out.println("Item added: " + element);
    }

    public T peek() {
        if (isEmpty())
            // An attempt was made to access an element that does not exist in a collection.
            throw new NoSuchElementException("The queue is empty");

        return elements.getFirst();
    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty");

        return elements.removeFirst();
    }

    public void print() {
        for (Object o : elements) {
            System.out.println(o);
        }
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
