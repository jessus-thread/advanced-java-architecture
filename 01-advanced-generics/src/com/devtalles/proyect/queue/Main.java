package com.devtalles.proyect.queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> numbers = new Queue<>();

        numbers.enqueue(10);
        numbers.enqueue(20);
        numbers.enqueue(30);

        numbers.print();

        System.out.println("See the first in line: " + numbers.peek());
        System.out.println("Remove the first one in the row: " + numbers.dequeue());

        numbers.print();
    }
}
