package com.devtalles.proyect.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        Stack<String> strings = new Stack<>();

        integers.push(1);
        integers.push(2);
        integers.push(200);

        strings.push("Gabriel");
        strings.push("Jesús");

        integers.print();
        strings.print();

        System.out.println("Element at the top: " + integers.peek());
        System.out.println("Remove element: " + integers.pop());

        integers.print();
    }
}
