package com.devtalles.proyect;

import java.util.ArrayList;
import java.util.List; // Best practice: Import the List interface

public class Main {
    public static void main(String[] args) {

        /* =========================================================================
         * 1. THE 'Object' TYPE (The root of everything)
         * =========================================================================
         * 'Object' has existed since version 1.0. Since every class in Java implicitly
         * inherits from Object, a variable of this type can mutate its content.
         */
        Object number = Integer.valueOf(10);
        number = "Hello!"; // Compiles perfectly because String is also an Object.
        System.out.println(number);

        /*
         * CRITICAL PROBLEM OF 'Object' -> Loss of "Type Safety":
         * 1. Loss of context: The compiler forgets what the data actually is. You don't have
         *    access to String methods (e.g., number.toUpperCase() would cause an error).
         * 2. Obligation of Casting: You would have to do (String) number to use it.
         * 3. Runtime Risk: If you make a mistake in the cast, the code will compile, but
         *    it will crash in production with the dreaded 'ClassCastException'.
         */

        /* =========================================================================
         * 2. TYPE INFERENCE WITH 'var'
         * =========================================================================
         * Introduced in Java 10. It does NOT turn Java into a dynamically typed
         * language (like JavaScript). It is simply "Syntactic Sugar" for the
         * developer. The compiler remains strict.
         *
         * RULES OF 'var':
         * - Only works for LOCAL variables (inside methods). Does not apply to class attributes.
         * - Must be initialized on the same line (you cannot do: var x; x = 10;).
         * - Once the compiler infers the type, it remains FIXED.
         */
        var name = "Jessus"; // The compiler silently translates it to: String name = "Jessus";
        // name = 10; // Compilation error! It is already strictly a String.
        System.out.println(name);

        /* =========================================================================
         * 3. GENERICS - Compile-time magic
         * =========================================================================
         * Introduced in Java 5 to solve the chaos of 'ClassCastException'.
         * They allow us to "parameterize" types to ensure data integrity.
         */

        // Architecture PRO-TIP: Always use the Interface ('List') on the left side
        // and the implementation ('ArrayList') on the right side.
        // The '<>' operator (Diamond Operator) appeared in Java 7 so you don't have to
        // repeat the type on the right side: new ArrayList<String>() -> new ArrayList<>().
        List<String> list = new ArrayList<>();

        list.add("Jessus");
        list.add("Minne");
        // list.add(10); // Magic! The compiler stops this error before executing the code.

        // When extracting data, the compiler guarantees that they are definitely Strings.
        // Zero extra validations, zero annoying casts.
        for (String nameItem : list) {
            System.out.println(nameItem.toUpperCase());
        }

        /* =========================================================================
         * 4. CUSTOM GENERIC CLASSES
         * =========================================================================
         * YOU decide the data type at the moment you instantiate the class.
         * GOLDEN RULE: Generics ONLY accept Classes/Objects (Reference Types),
         * they do NOT accept primitives (int, double, boolean).
         * That's why we pass 'Integer' instead of 'int'.
         */
        Box<String> stringBox = new Box<>("jessus");
        System.out.println("String Box: " + stringBox);

        Box<Integer> integerBox = new Box<>(20);
        // Note: When passing '20', Java performs automatic "Autoboxing" from int to Integer.
        System.out.println("Integer Box: " + integerBox);
    }
}