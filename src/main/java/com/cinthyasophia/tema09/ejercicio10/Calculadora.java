package com.cinthyasophia.tema09.ejercicio10;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * Calculadora
 */

public class Calculadora {
    public Random rnd = new Random();
    public final int SLEEP=2000;
    private boolean isNumber;
    private double pOperador=0;
    private double sOperador=0;
    private double resultado=0;

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
        pOperador=Integer.parseInt(datosAleatorios());
        sOperador=Integer.parseInt(datosAleatorios());
        do {
            try {
                resultado= pOperador + sOperador;
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }catch (NumberFormatException nfe){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" + " +sOperador+ " = "+ resultado);
    }

    public void resta(){
        pOperador=Integer.parseInt(datosAleatorios());
        sOperador=Integer.parseInt(datosAleatorios());

        do {
            try {
                resultado= pOperador - sOperador;
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }catch (NumberFormatException nfe){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" - " +sOperador+ " = "+ resultado);
    }

    public void multiplicacion(){
        pOperador=Integer.parseInt(datosAleatorios());
        sOperador=Integer.parseInt(datosAleatorios());

        do {
            try {
                resultado= pOperador * sOperador;
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }catch (NumberFormatException nfe){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" * " +sOperador+ " = "+ resultado);
    }
    public void division(){

        do {
            try {
                resultado= pOperador / sOperador;
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }catch (NumberFormatException nfe){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" / " +sOperador+ " = "+ resultado);
    }
    public void restoDivision(){
        pOperador=Integer.parseInt(datosAleatorios());
        sOperador=Integer.parseInt(datosAleatorios());

        do {
            try {
                resultado= pOperador % sOperador;
                isNumber=true;

            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }catch (NumberFormatException nfe){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println("El resto de "+pOperador +" / "+ sOperador + " es "+ resultado);
    }
    public int menuCalculadora() {
        int decision=0;
        System.out.println("\n1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Resto de una division");
        System.out.println("-------------------------");
        System.out.println("0. Salir");
        do {
            try{
                decision=Integer.parseInt(datosAleatorios());
            }catch (InputMismatchException ime){
                System.out.println("No se pueden realizar operaciones con letras, volviendo a buscar.");
            }

        }while(decision>5);

        System.out.println("Opcion: "+decision+'\n');

        return decision;

    }
    public String datosAleatorios(){
        int[] numeros = new int[23];
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String caracter;
        int numAl;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=rnd.nextInt(20);
        }
        numAl=rnd.nextInt(50);
        if (numAl<26){
            caracter= String.valueOf(letras.charAt(numAl));

        }else{
            numAl=rnd.nextInt(23);
            caracter= Integer.toString(numeros[numAl]);
        }

        return caracter;

    }
}