package com.devtalles.proyect;

/**
 * Utility class that demonstrates the creation and use of Generic Methods.
 * Note: This class is NOT generic, but it contains methods that are.
 */
public class Utility {

    /* =========================================================================
     * 1. SIMPLE GENERIC METHOD
     * =========================================================================
     * Key syntax: The diamond <T> MUST go before the return type (void).
     * This tells the compiler: "Attention, the letter T you will see in the
     * parameters is not an existing class, it is a Generic Type Parameter".
     */

    /**
     * Prints any type of element to the console.
     *
     * @param <T>   The data type inferred at compile time.
     * @param value The value to print.
     */
    public static <T> void printItem(T value) {
        System.out.println(value);
    }

    /* =========================================================================
     * 2. MULTIPLE GENERIC METHOD (Method overloading)
     * =========================================================================
     * We can declare multiple generic parameters by separating them with commas.
     * By convention, when associating two values, <K, V>
     * (Key, Value) is usually used, but the syntax supports any combination of letters.
     */

    /**
     * Prints a pair of associated elements to the console.
     *
     * @param <T>   The data type of the first value.
     * @param <K>   The data type of the key.
     * @param value The main value.
     * @param key   The key associated with that value.
     */
    public static <T, K> void printItem(T value, K key) {
        System.out.println(value + " " + key);
    }
}