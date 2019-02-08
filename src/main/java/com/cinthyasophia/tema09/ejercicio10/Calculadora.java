package com.cinthyasophia.tema09.ejercicio10;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * Calculadora
 */

public class Calculadora {
    public Random rnd = new Random();
    public boolean isNumber;
    public final int SLEEP=1000;

    public Calculadora() throws InterruptedException {

        int decision;
        do {     
           decision= menuCalculadora();
           Thread.sleep(SLEEP);

            switch (decision) {

                case 1:
                   suma();
                    break;

                case 2:
                    resta();
                    break;

                case 3:
                    multiplicacion();
                    break;

                case 4:
                    division();
                    break;

                case 5:
                    restoDivision();
                    break;

                default: 
                    System.out.println("ADIOS.");
                    break;
            }

        } while (decision != 0);


    }
    public void suma(){
        float pSumando=0;
        float sSumando=0;
        float suma;

        suma= pSumando + sSumando;

        System.out.println(pSumando +" + " +sSumando+ " = "+ suma);
    }
    public void resta(){
        float minuendo=0;
        float sustraendo=0;
        float resta;

        resta= sustraendo - minuendo;

        System.out.println(sustraendo+ " - "+minuendo+ " = "+ resta);
    }
    public void multiplicacion(){
        float pFactor=0;
        float sFactor=0;
        float producto;

        producto= pFactor * sFactor;

        System.out.println(pFactor +" * "+ sFactor +  " = "+ producto);
    }
    public void division(){
        float dividendo=0;
        float divisor=0;
        float cociente;

        cociente= dividendo / divisor;

        System.out.println(dividendo +" / "+ divisor + " = "+ cociente);
    }
    public void restoDivision(){
        float rDividendo=0;
        float rDivisor=0;
        float resto;

        resto= rDividendo % rDivisor;

        System.out.println("El resto de "+rDividendo +" / "+ rDivisor + " es "+ resto);
    }
    public int menuCalculadora() {
        int decision;
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Resto de una division");
        System.out.println("-------------------------");
        System.out.println("0. Salir");
        do {
            decision=datosAleatorios();

        }while(decision>5);

        System.out.println("Opcion:"+decision);

        return decision;

    }
    public int datosAleatorios(){

        int[] vector = new int[20];
        int numero;
        int numAl=rnd.nextInt(vector.length);

        for (int i = 0; i <vector.length ; i++) {
            vector[i]=i;
        }
        numero=vector[numAl];

        return numero;

    }
}