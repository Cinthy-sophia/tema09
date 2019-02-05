package com.cinthyasophia.tema09.ejercicio07;

import java.util.Scanner;

public class Ejercicio07 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio07(){
        String[] palabras= new String[5];

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduce la cadena numero "+i+" del array.");
            palabras[i]= lector.nextLine();
        }

        mostrarCadenasArray(palabras);
    }

    public void mostrarCadenasArray(String[] vector){
        String p;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == null) {
                System.out.println("Esta posicion esta vacia.");
            } else{
                p=vector[i].substring(0,2);
                System.out.println(p);
            }

        }


    }
}
