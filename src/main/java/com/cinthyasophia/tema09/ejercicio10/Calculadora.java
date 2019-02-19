package com.cinthyasophia.tema09.ejercicio10;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * Calculadora
 */

public class Calculadora {
    private Random rnd = new Random();
    private final int SLEEP=1500;
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
        do {
            try {
                pOperador=Integer.parseInt(datosAleatorios());
                sOperador=Integer.parseInt(datosAleatorios());
                resultado= pOperador + sOperador;
                isNumber=true;

            } catch(NumberFormatException nfe){
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" + " +sOperador+ " = "+ resultado);
    }

    public void resta(){

        do {
            try {
                pOperador=Integer.parseInt(datosAleatorios());
                sOperador=Integer.parseInt(datosAleatorios());
                resultado= pOperador - sOperador;
                isNumber=true;

            }catch (NumberFormatException nfe){
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" - " +sOperador+ " = "+ resultado);
    }

    public void multiplicacion(){

        do {
            try {
                pOperador=Integer.parseInt(datosAleatorios());
                sOperador=Integer.parseInt(datosAleatorios());
                resultado= pOperador * sOperador;
                isNumber=true;

            }catch (NumberFormatException nfe){
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" * " +sOperador+ " = "+ resultado);
    }
    public void division(){

        do {
            try {
                pOperador=Integer.parseInt(datosAleatorios());
                sOperador=Integer.parseInt(datosAleatorios());
                resultado= pOperador / sOperador;
                isNumber=true;


            }catch (NumberFormatException nfe){
                isNumber=false;
            }

        }while(!isNumber);

        System.out.println(pOperador +" / " +sOperador+ " = "+ resultado);
    }
    public void restoDivision(){

        do {
            try {
                pOperador=Integer.parseInt(datosAleatorios());
                sOperador=Integer.parseInt(datosAleatorios());
                resultado= pOperador % sOperador;
                isNumber=true;

            }catch (NumberFormatException nfe){
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
                isNumber=true;

            }catch (NumberFormatException nfe){
                isNumber=false;
            }

        }while(decision>5||!isNumber);

        System.out.println("Opcion: "+decision+'\n');

        return decision;

    }
    public String datosAleatorios(){
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String caracter;
        int numAl;

        numAl=rnd.nextInt(50);
        if (numAl<26){
            caracter= String.valueOf(letras.charAt(numAl));
        }else{
            numAl=rnd.nextInt(23);
            caracter= Integer.toString(numAl);
        }

        return caracter;

    }
}