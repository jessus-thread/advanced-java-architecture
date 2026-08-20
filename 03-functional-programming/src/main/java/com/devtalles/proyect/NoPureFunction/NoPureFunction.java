package com.devtalles.proyect.NoPureFunction;

public class NoPureFunction {

    /*
        ESTADO GLOBAL O EXTERNO
        Esta variable vive fuera de la función. En el mundo de la programación
        funcional, el estado global es considerado un "peligro" porque cualquier
        parte del programa puede alterarlo de forma inesperada.
    */
    static int count = 0;

    /*
        FUNCIÓN IMPURA

        Esta función se considera impura porque rompe de forma directa las
        dos reglas inquebrantables de la programación funcional:

        1. Rompe el Determinismo:
           Una función determinista siempre devuelve lo mismo si le pasas lo mismo.
           Aquí, si llamas a incrementCounter(5) por primera vez, devuelve 5.
           Si la vuelves a llamar con el mismo 5, ahora devuelve 10.
           El resultado es impredecible porque depende de un historial oculto (count).

        2. Produce Efectos Secundarios (Side Effects):
           La función no se limita a calcular un resultado matemático, sino que
           "sale" de su propio bloque de código para alterar el mundo exterior
           (modificando la variable estática 'count').

        EL PROBLEMA EN LA VIDA REAL:
        Si dos hilos (threads) intentan ejecutar esta función exactamente al
        mismo tiempo en un servidor Spring Boot, ambos intentarán sumar a 'count'
        simultáneamente. Esto causa una colisión de datos conocida como
        "Condición de Carrera" (Race Condition), corrompiendo tu base de datos
        o la memoria del servidor.
    */
    public static int incrementCounter(int value) {
        count += value;

        return count;
    }
}