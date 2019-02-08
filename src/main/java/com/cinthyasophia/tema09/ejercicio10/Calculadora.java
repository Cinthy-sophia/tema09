package com.cinthyasophia.tema09.ejercicio10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculadora
 */

public class Calculadora {
    public Scanner lector = new Scanner (System.in);
    public boolean isNumber;

    public Calculadora() {

        int decision;
        do {     
           decision= menuCalculadora();
            //Utilizo un switch para cada caso.
            switch (decision) {

                //En caso de suma.
                case 1:
                   suma();
                    break;

                //En caso de resta.

                case 2:
                    resta();
                    break;

                //En caso de multiplicacion.

                case 3:
                    multiplicacion();
                        
                    break;

                //En caso de division.

                case 4:
                    division();
                    
                    break;

                //En caso de que pidan el resto de una division.

                case 5:
                    restoDivision();
                    
                    break;

                default: 
                    System.out.println("ADIOS.");
                    break;
            }

           //El bucle dejara de ejecutarse cuando el usuario introduzca un 0. 
        } while (decision != 0);


    }
    public void suma(){
        float pSumando=0;
        float sSumando=0;
        float suma;
        do {
            System.out.print("Primer sumando: ");
            try{
                pSumando= lector.nextFloat();
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("Debes introducir un numero no una letra, vuelve a intentarlo.");
                isNumber=false;

            }finally {
                lector.nextLine();
            }
        }while(!isNumber);


        do {
            System.out.print("Segundo sumando: ");
            try{
                sSumando= lector.nextFloat();
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("Debes introducir un numero no una letra, vuelve a intentarlo.");
                isNumber=false;

            }finally {
                lector.nextLine();
            }
        }while(!isNumber);

        suma= pSumando + sSumando;

        System.out.println(pSumando +" + " +sSumando+ " = "+ suma);
    }
    public void resta(){
        float minuendo;
        float sustraendo;
        float resta;

        System.out.print("Sustraendo: ");
        sustraendo= lector.nextFloat();
        lector.nextLine();

        System.out.print("Minuendo: ");
        minuendo= lector.nextFloat();
        lector.nextLine();


        resta= sustraendo - minuendo;

        System.out.println(sustraendo+ " - "+minuendo+ " = "+ resta);
    }
    public void multiplicacion(){
        float pFactor;
        float sFactor;
        float producto;

        System.out.print("Introduce los datos y presiona intro: ");
        pFactor= lector.nextFloat();
        lector.nextLine();

        sFactor= lector.nextFloat();
        lector.nextLine();

        // Se ejecuta la multiplicacion y luego se imprime.

        producto= pFactor * sFactor;

        System.out.println(pFactor +" * "+ sFactor +  " = "+ producto);
    }
    public void division(){
        float dividendo;
        float divisor;
        float cociente;

        System.out.print("Introduce los datos y presiona intro: ");
        dividendo= lector.nextFloat();
        lector.nextLine();

        divisor= lector.nextFloat();
        lector.nextLine();

        // Se ejecuta la division y luego se imprime.

        cociente= dividendo / divisor;

        System.out.println(dividendo +" / "+ divisor + " = "+ cociente);
    }
    public void restoDivision(){
        float rDividendo;
        float rDivisor;
        float resto;

        System.out.print("Introduce los datos y presiona intro: ");
        rDividendo= lector.nextFloat();
        lector.nextLine();


        rDivisor= lector.nextFloat();
        lector.nextLine();

        // Se ejecuta la division, se calcula el resto y luego se imprime.

        resto= rDividendo % rDivisor;

        System.out.println("El resto de "+rDividendo +" / "+ rDivisor + " es "+ resto);
    }
    public int menuCalculadora() {
        int decision=0;
        boolean isNumber;
        //La lista de ordenes a ejecutar.
        System.out.println("Elige una opcion y presiona intro:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Resto de una division");
        System.out.println("-------------------------");
        System.out.println("0. Salir");
        do {
            try{
                decision = lector.nextInt();
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("Debes introducir un numero no una letra, vuelve a intentarlo.");
                isNumber=false;

            }finally {
                lector.nextLine();
            }
        }while(!isNumber);

        return decision;

    }
    public void datosAleatorios(){
        int[] vector = new int[20];
    }
}