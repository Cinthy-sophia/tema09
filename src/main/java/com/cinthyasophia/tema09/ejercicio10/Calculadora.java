package com.cinthyasophia.tema09.ejercicio10;

import java.util.Scanner;

/**
 * Calculadora
 */

public class Calculadora {
    public Scanner lector = new Scanner (System.in);

    public Calculadora() {

        //Declaro las variables al inicio del todo.
        int decision;
        float pSumando;
        float sSumando;
        float suma;

        float minuendo;
        float sustraendo;
        float resta;

        float pFactor;
        float sFactor;
        float producto;

        float dividendo;
        float divisor;
        float cociente;

        float rDividendo;
        float rDivisor;
        float resto;

        //Utilizo un bucle do para la ejecucion.

        do {     
           decision= menuCalculadora();
            //Utilizo un switch para cada caso.
            switch (decision) {

                //En caso de suma.

                case 1:

                    System.out.print("Introduce los datos y presiona intro: ");
                    pSumando= lector.nextFloat();
                    lector.nextLine();

                    System.out.print(" + ");

                    sSumando= lector.nextFloat();
                    lector.nextLine();

                    // Se ejecuta la suma y luego se imprime.

                    suma= pSumando + sSumando;

                    System.out.println(pSumando +" + " +sSumando+ " = "+ suma);
                
                    break;

                //En caso de resta.

                case 2:
                    System.out.print("Introduce los datos y presiona intro: ");
                    sustraendo= lector.nextFloat();
                    lector.nextLine();

                    System.out.print(" - ");

                    minuendo= lector.nextFloat();
                    lector.nextLine();

                    // Se ejecuta la resta y luego se imprime.

                    resta= sustraendo - minuendo;

                    System.out.println(sustraendo+ " - "+minuendo+ " = "+ resta);
                        
                    break;

                //En caso de multiplicacion.

                case 3:
                    System.out.print("Introduce los datos y presiona intro: ");
                    pFactor= lector.nextFloat();
                    lector.nextLine();

                    System.out.print(" * ");

                    sFactor= lector.nextFloat();
                    lector.nextLine();

                    // Se ejecuta la multiplicacion y luego se imprime.

                    producto= pFactor * sFactor;

                    System.out.println(pFactor +" * "+ sFactor +  " = "+ producto);
                        
                    break;

                //En caso de division.

                case 4:
                    System.out.print("Introduce los datos y presiona intro: ");
                    dividendo= lector.nextFloat();
                    lector.nextLine();

                    System.out.print(" / ");

                    divisor= lector.nextFloat();
                    lector.nextLine();

                    // Se ejecuta la division y luego se imprime.

                    cociente= dividendo / divisor;

                    System.out.println(dividendo +" / "+ divisor + " = "+ cociente);
                    
                    break;

                //En caso de que pidan el resto de una division.

                case 5:
                    System.out.print("Introduce los datos y presiona intro: ");
                    rDividendo= lector.nextFloat();
                    lector.nextLine();

                    System.out.print(" % ");

                    rDivisor= lector.nextFloat();
                    lector.nextLine();

                    // Se ejecuta la division, se calcula el resto y luego se imprime.

                    resto= rDividendo % rDivisor;

                    System.out.println(rDividendo +" % "+ rDivisor + " = "+ resto);
                    
                    break;

                default: 
                    System.out.println("ADIOS.");
                    break;
            }

           //El bucle dejara de ejecutarse cuando el usuario introduzca un 0. 
        } while (decision != 0);



        
    }
    public int menuCalculadora() {
        int decision;
        //La lista de ordenes a ejecutar.
        System.out.println("Elige una opcion y presiona intro:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Resto de una division");
        System.out.println("-------------------------");
        System.out.println("0. Salir");
        decision = lector.nextInt();
        lector.nextLine();
        return decision;

    }
}