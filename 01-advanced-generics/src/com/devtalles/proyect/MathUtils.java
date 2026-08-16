package com.devtalles.proyect;

public class MathUtils {

    /* =========================================================================
     * BOUNDED TYPE PARAMETERS
     * =========================================================================
     * By using <T extends Number>, we tell the compiler: "The letter T can only
     * be the Number class or any subclass (Integer, Double, Float...)".
     */

    /**
     * Adds two numbers of any numeric type supported by Java.
     * By restricting T to 'Number', the compiler allows us to use the internal
     * methods of that parent class, such as doubleValue(), intValue(), etc.
     *
     * @param <T> The inferred numeric type (must inherit from java.lang.Number).
     * @param a   The first operand.
     * @param b   The second operand.
     * @return    The sum of both converted to double to avoid loss of precision.
     */
    public static <T extends Number> double sum(T a, T b) {

        // If T were just <T> (without extends), Java would treat it as an Object.
        // And since Object does not have the doubleValue() method, the code would throw an error.
        // Thanks to the restriction, the compiler knows that a and b do have this method.
        return a.doubleValue() + b.doubleValue();

        /*
         * Implicit use cases:
         * MathUtils.sum(10, 20.5);       // Works! (T = Number)
         * MathUtils.sum("10", "20");     // Compilation error! String does not inherit from Number.
         */
    }
}