package com.devtalles.proyect;

/**
 * Represents a generic container (Wrapper).
 *
 * @param <T> The data type (Type) that this box will store.
 *            When instantiating the class, the compiler will replace 'T'
 *            with the actual object (String, Integer, Customer, etc.).
 */
public class Box<T> {

    // The internal attribute will dynamically adopt the specified type
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value + // Implicitly calls the toString() of the 'T' object
                '}';
    }
}