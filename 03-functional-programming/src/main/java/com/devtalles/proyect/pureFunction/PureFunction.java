package com.devtalles.proyect.pureFunction;

import java.util.function.Function;

public class PureFunction {

    /*
       ENFOQUE IMPERATIVO (Tradicional)
       Es una función pura porque es determinista (si entra 4, sale 8)
       y no tiene efectos secundarios (no altera el estado externo).
     */
    public static int multiplyByTwo(int number) {
        return number * 2;
    }

    public static void main(String[] args) {

        // Ejecución clásica imperativa
        int result = multiplyByTwo(4);
        System.out.println("El resultado imperativo es: " + result);

        PureFunction pureFunction = new PureFunction();
        pureFunction.functionalProgramming();
    }

    /*
        ENFOQUE DECLARATIVO (Programación Funcional Moderna)
        Utilizamos las interfaces funcionales nativas de Java.
     */
    public void functionalProgramming() {

        /*
            Function<T, R> es una interfaz funcional de Java.
            T (Input)  -> Integer (Lo que recibe la lambda: 'num')
            R (Output) -> Integer (Lo que retorna la lambda: 'num * 2')

            Ahora el "comportamiento" está guardado en una variable (multiply).
         */
        Function<Integer, Integer> multiply = (num) -> num * 2;

        // El método .apply() ejecuta la expresión lambda pasando el argumento.
        Integer result = multiply.apply(4);

        System.out.println("El resultado funcional es: " + result);
    }
}