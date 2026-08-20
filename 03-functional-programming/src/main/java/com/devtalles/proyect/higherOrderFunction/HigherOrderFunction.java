package com.devtalles.proyect.higherOrderFunction;

public class HigherOrderFunction {

    public static void main(String[] args) {
        /*
            INYECCIÓN DEL COMPORTAMIENTO (El Callback)

            Aquí no estamos pasando una variable con un valor estático,
            estamos inyectando la LÓGICA pura de lo que queremos que suceda.
            La expresión lambda (x, y) -> x * y es el comportamiento que viaja
            como argumento hacia la función de orden superior.
            Si mañana queremos sumar, solo cambiamos este lambda sin tocar
            nada del resto del sistema: applyOperation(6, 2, (x, y) -> x + y);
        */
        applyOperation(6, 2, (x, y) -> x * y);
    }

    /*
        FUNCIÓN DE ORDEN SUPERIOR (Higher-Order Function)

        En programación funcional, una función recibe el título de
        "Orden Superior" si cumple al menos UNA de estas dos reglas matemáticas:
        1. Recibe otra función como argumento (nuestro caso aquí con 'op').
        2. Devuelve una función como resultado.

        El Superpoder Arquitectónico (Patrón Strategy nativo):
        Esta función está completamente ciega y desacoplada de la lógica de negocio.
        A 'applyOperation' no le importa si sumas, restas o haces cálculo avanzado.
        Su única responsabilidad es orquestar: recibe los datos, ejecuta el
        comportamiento que le pasaron desde afuera y muestra el resultado.

        Esto cumple perfectamente el principio Abierto/Cerrado (Open/Closed Principle)
        de SOLID: El código está cerrado a modificaciones (nunca más tendrás que
        editar este método), pero abierto a extensión (puedes pasarle infinitas
        operaciones matemáticas diferentes desde el main).
    */
    public static void applyOperation(int x, int y, Operation op) {
        int result = op.compute(x, y);

        System.out.println("El resultado de la operación es: " + result);
    }
}

/*
    EL CONTRATO FUNCIONAL

    Define la "firma" o el molde estricto que cualquier comportamiento
    deberá cumplir (recibir dos enteros y devolver un entero) para poder
    ser inyectado en nuestra Función de Orden Superior.
*/
@FunctionalInterface
interface Operation {
    int compute(int a, int b);
}