package com.devtalles.proyect;

import java.util.ArrayList;
import java.util.List;

public class WildcardsMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jess");
        names.add("Ale");
        names.add("Minn");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(23);
        numbers.add(18);
        numbers.add(12);

        printList(names);
        printList(numbers);
        sumNumbers(numbers);
        addNumbers(numbers);
    }

    /* =========================================================================
     * 1. UNBOUNDED WILDCARD (<?>)
     * =========================================================================
     * Means: "A list of an unknown type".
     * Ideal use: When the method does NOT depend on the data type (e.g., printing, checking size).
     */
    public static void printList(List<?> list) {
        // We can READ because no matter what, it will always be at least an Object.
        for (Object o : list) {
            System.out.println(o);
        }

        /*
         * COMPILER PROTECTION (Type Safety):
         * We cannot add anything (except null) because the compiler doesn't know
         * what type of list it actually is. If it were a List<String> and it let us
         * do list.add(20), we would break the application.
         */
        // list.add(20); // ERROR: Incompatible types.
        list.add(null);  // VALID: null belongs to any object type.
    }

    /* =========================================================================
     * 2. COVARIANCE (Upper Bounded Wildcard: <? extends T>)
     * =========================================================================
     * Means: "Accepts any list whose type is T or a SUBCLASS of T".
     * Behavior: READ-ONLY.
     */
    public static void sumNumbers(List<? extends Number> numbers) {
        double sum = 0;

        // We can READ with complete certainty that the elements are at least 'Number'.
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println(sum);

        // numbers.add(10); // ERROR: We don't know if the original list was a List<Double>.
        // Putting an Integer into a List<Double> would break integrity.
    }

    /* =========================================================================
     * 3. CONTRAVARIANCE (Lower Bounded Wildcard: <? super T>)
     * =========================================================================
     * Means: "Accepts any list whose type is T or a SUPERCLASS of T".
     * Behavior: WRITE-ONLY. It's the solution for modifying.
     */
    public static void addNumbers(List<? super Integer> numbers) {
        // We can WRITE because we know with certainty that the original list
        // can contain Integers (whether it's a List<Integer>, List<Number>, or List<Object>).
        numbers.add(134);
        numbers.add(222);

        /*
         * PROBLEM WHEN READING:
         * Since the list could generically be a List<Object>, the compiler
         * cannot guarantee that extracting an element will yield an Integer.
         * Therefore, it forces you to treat whatever you read as an 'Object'.
         */
        Object num = numbers.get(0);
        System.out.println("Modified: " + numbers);
    }
}