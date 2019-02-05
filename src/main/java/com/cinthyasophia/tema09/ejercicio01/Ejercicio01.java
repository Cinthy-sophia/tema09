package com.cinthyasophia.tema09.ejercicio01;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {
    public Scanner lector = new Scanner(System.in);

    public void pedirNumeros(){
        boolean isNegativo;
        int numeros;

        do {
            System.out.println("Introduce un numero: ");
            isNegativo=false;
            try{
                numeros= lector.nextInt();
                System.out.println(numeros);

                if (numeros<0){
                    isNegativo=true;

                }
            }catch (InputMismatchException e){
                System.out.println("Debes introducir un numero, no una letra.");
                lector.nextLine();
            }

        }while(!isNegativo);
    }
}
