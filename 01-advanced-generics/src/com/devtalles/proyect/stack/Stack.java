package com.devtalles.proyect.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T element) {
        elements.add(element);

        System.out.println("Added element... " + element);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }

        return elements.getLast();
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }

        return elements.removeLast();
    }

    public void print() {
        for (Object o : elements) {
            System.out.println(o);
        }
    }
}
