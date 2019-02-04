package com.cinthyasophia.tema09.ejercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio02(){
        double max =0;
        double numeros;
        int cont=0;

        do {
            System.out.println("Introduce un numero: ");
            try{
                numeros= lector.nextDouble();
                System.out.println(numeros);
                if (numeros>max){
                    max=numeros;
                }
                cont++;
            }catch (InputMismatchException e){
                lector.nextLine();

            }

        }while(cont<10);
        System.out.println("El numero mayor es "+max);
    }
}
