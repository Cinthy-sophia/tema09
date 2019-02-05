package com.cinthyasophia.tema09.ejercicio04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {
    public Scanner lector = new Scanner(System.in);

    public void llenarArray(int[] vector){
        int num;
        int cont=0;
        boolean isNumber;

        do {
            System.out.println("Introduce un numero:");
            isNumber=true;
            try{
                num= lector.nextInt();
                vector[cont]=num;
                cont++;
            } catch (InputMismatchException ime){
                System.out.println("Debes introducir un numero, no una letra.");
                isNumber=false;

            } catch (IndexOutOfBoundsException iobe){
                System.out.println("El array ya ha sido llenado.");
                System.out.println(Arrays.toString(vector));

            } catch (NullPointerException npe){
                System.out.println("El array no ha sido creado.");
                return;

            } finally {
                lector.nextLine();
            }

        }while(!isNumber);

    }
}
