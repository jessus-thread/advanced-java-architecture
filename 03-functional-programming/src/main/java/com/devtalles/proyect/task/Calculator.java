package com.devtalles.proyect.task;

public class Calculator {

    /*
        FUNCIÓN IMPURA DE ORDEN SUPERIOR

        1. Es de "Orden Superior" porque recibe una interfaz funcional (comportamiento)
           como parámetro a través de 'Operation op'.
        2. Es "Impura" porque produce un efecto secundario: usar System.out.println()
           para alterar la consola (el mundo exterior).

        A nivel de diseño, 'Calculator' actúa como un orquestador ciego. Su única
        responsabilidad es tomar dos números, pasárselos al comportamiento inyectado
        y mostrar el resultado. No sabe, ni le importa, qué operación matemática
        se está realizando realmente.
    */
    public void operateAndPrint(int a, int b, Operation op) {
        int result = op.operate(a, b);

        System.out.println("Print result: " + result);
    }

    static void main(String[] args) {

        /*
            COMPORTAMIENTO ALMACENADO EN MEMORIA (Reusabilidad)

            Al asignar la lambda a una variable, tratamos a la función como si
            fuera un dato (como un int o un String). Esto es ideal si esta misma
            lógica de multiplicación se va a reutilizar en múltiples lugares del
            programa sin tener que reescribirla.
        */
        Operation operation = (a, b) -> a * b;

        Calculator calculator = new Calculator();

        calculator.operateAndPrint(20, 90, operation);

        /*
            COMPORTAMIENTO INYECTADO AL VUELO (On the fly)

            Esta es la forma más común y elegante de usar lambdas en la industria.
            Si el comportamiento es de un solo uso, no ensuciamos la memoria creando
            variables previas; simplemente inyectamos la lógica directamente en
            el argumento.

            Aquí presenciamos un Polimorfismo Dinámico brutal: la misma instancia
            de 'calculator' y el mismo método 'operateAndPrint' cambian su
            naturaleza por completo en cada línea (suma, multiplica, resta)
            dependiendo exclusivamente de la regla de negocio que le inyectes.
        */
        calculator.operateAndPrint(123, 456, (firstValue, secondValue) -> firstValue + secondValue);
        calculator.operateAndPrint(30, 90, (a, b) -> a * b);
        calculator.operateAndPrint(12, 90, (a, b) -> a - b);
    }
}

/*
    EL CONTRATO ESTRUCTURAL

    Obliga a que cualquier lambda inyectada en Calculator reciba exactamente
    dos enteros y retorne un entero.
*/
@FunctionalInterface
interface Operation {
    int operate(int a, int b);
}