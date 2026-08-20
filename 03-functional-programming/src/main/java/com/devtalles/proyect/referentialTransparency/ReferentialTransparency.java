package com.devtalles.proyect.referentialTransparency;

public class ReferentialTransparency {

    /*
        FUNCIÓN PURA (El requisito previo)

        Para que exista la transparencia referencial, la función debe ser
        estrictamente pura. Aquí, 'triple(x)' siempre devolverá el mismo
        resultado para el mismo valor de 'x', y no tiene ningún efecto
        secundario externo.
    */
    public static int triple(int x) {
        return x * 3;
    }

    /*
        TRANSPARENCIA REFERENCIAL (El concepto clave)

        La transparencia referencial es una propiedad matemática que nos dice:
        "Si puedes reemplazar la llamada a una función directamente por su
        resultado final calculado, sin que el programa cambie su comportamiento
        o falle, entonces la función es referencialmente transparente".

        En este ejemplo:
        Sabemos que triple(3) siempre, obligatoriamente, es igual a 9.
        Por lo tanto, la expresión 'triple(3) + 2' (result2) es matemáticamente
        y lógicamente idéntica a escribir '9 + 2' (resul1).

        ¿Por qué es esto vital para la ingeniería a gran escala?

        1. Testing perfecto: Hacer pruebas unitarias (Unit Tests) de esto es
           increíblemente fácil. No necesitas inicializar bases de datos, ni
           sesiones de usuario, ni mocks complejos.

        2. Optimización por Caché (Memoization): Si el compilador o tu servidor
           sabe que triple(3) siempre es 9, podrías guardar ese '9' en caché
           (como Redis) la primera vez que se calcula. Las siguientes miles de
           veces que se llame a triple(3), el sistema devolverá el 9 de la
           memoria inmediatamente en lugar de volver a gastar CPU en calcularlo.

        3. Refactorización sin miedo: Puedes extraer, mover o reescribir esta
           función sin el pánico de romper algún estado global en el sistema.
    */
    public static void main(String[] args) {

        // Ejecución reemplazando mentalmente la función por su valor literal
        int resul1 = 9 + 2;

        // Ejecución llamando a la función referencialmente transparente
        int result2 = triple(3) + 2;

        System.out.println("result 1: " + resul1);
        System.out.println("result 2: " + result2);
    }
}