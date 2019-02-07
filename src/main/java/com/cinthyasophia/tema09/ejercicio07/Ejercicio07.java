package com.cinthyasophia.tema09.ejercicio07;

import java.util.Scanner;

public class Ejercicio07 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio07(){
        String[] palabras = new String[5];

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduce la cadena numero "+(i+1)+" del array.");
            palabras[i]= lector.nextLine();

            if (palabras[i].isEmpty()){
                palabras[i]=null;
            }
        }

        mostrarCadenasArray(palabras);
    }

    public void mostrarCadenasArray(String[] vector){
        String p;

        for (int i = 0; i < vector.length; i++) {

            if (vector[i] != null) {
                p=vector[i];
                System.out.println(p.charAt(0));
            } else{
                System.out.println("Esta posicion esta vacia.");
            }

        }


    }
}
