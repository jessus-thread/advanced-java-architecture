package com.devtalles.proyect;

/*
    Se podría resumir que sirven cuando queremos pasar una función como argumento
    a otra función, algo así como los callbacks en js

    Cuando en JavaScript haces un array.map(item => item * 2) o pasas una función
    para que se ejecute después de un evento, estás pasando comportamiento puro
    como argumento. Java, al ser un lenguaje históricamente estricto y 100% orientado
    a objetos, no permitía pasar "funciones sueltas"; todo tenía que vivir forzosamente
    dentro de un objeto (por eso existía la verbosa clase anónima).
 */

public class Main {
    public static void main(String[] args) {

        /*
            1. CLASE ANÓNIMA (El enfoque clásico pre-Java 8)

            No estamos instanciando una interfaz (lo cual es imposible).
            Estamos indicándole a Java que cree una clase sin nombre "al vuelo"
            en la memoria que implemente la interfaz Operation y sobreescriba su método.

            Desventaja: Mucho código "boilerplate" (repetitivo) para una lógica simple.
         */
        Operation oldOperation = new Operation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Suma con clase anónima: " + oldOperation.operate(5, 5));

        /*
            2. EXPRESIÓN LAMBDA (El enfoque moderno)

            Simplifica la clase anónima a su mínima expresión.
            Sintaxis: (parámetros) -> { cuerpo de la función }
            Java sabe que 'a' y 'b' son enteros porque lee el contrato de la interfaz Operation.
         */
        Operation multiply = (int a, int b) -> {
            return a * b;
        };

        /*
            3. LAMBDA OPTIMIZADA (Type Inference)

            Si el cuerpo tiene una sola línea, podemos omitir las llaves {} y la palabra 'return'.
            Además, podemos omitir el tipo de dato (int) porque Java lo infiere de la interfaz.
         */
        Operation sum = (a, b) -> a + b;

        System.out.println("Multiplicación con Lambda: " + multiply.operate(1, 7));
        System.out.println("Suma con Lambda optimizada: " + sum.operate(3, 5));

        // Uso de un método estático de la interfaz
        Operation sub = Operation.subtraction();
        System.out.println("Resta invocada desde método estático: " + sub.operate(10, 4));
    }
}

/*
    @FunctionalInterface: Es una anotación de seguridad (como @Override).
    Le dice al compilador: "Asegúrate de que esta interfaz tenga EXACTAMENTE UN método abstracto".
    Si alguien intenta agregar un segundo método abstracto en el futuro, el código no compilará,
    protegiendo así a todas las expresiones Lambda que dependen de ella.
 */
@FunctionalInterface
interface Operation {

    // MÉTODO ABSTRACTO: Es el "contrato" que las lambdas deben cumplir.
    int operate(int a, int b);

    /*
        MÉTODOS POR DEFECTO (default)
        Introducidos en Java 8. Permiten agregar nueva funcionalidad a interfaces
        existentes sin romper las clases que ya las implementaban.
        Las clases o lambdas que implementen 'Operation' tendrán acceso a estos métodos
        automáticamente sin necesidad de sobreescribirlos.
     */
    default String show() {
        return "I am an operation";
    }

    default String show2() {
        return "I am an operation 2";
    }

    /*
        MÉTODOS ESTÁTICOS
        Pertenecen a la interfaz en sí, no a la instancia.
        Son útiles para crear métodos "Factory" (Fábricas) que devuelven configuraciones
        predefinidas de la misma interfaz.
     */
    static Operation subtraction() {
        return (a, b) -> a - b;
    }
}