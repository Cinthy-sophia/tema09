package com.cinthyasophia.tema09.ejercicio05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio05(){
        Alumno alumno1;
        Alumno alumno2;

        alumno1= crearAlumno();
        alumno2= crearAlumno();

        System.out.println("\u001B[H\u001B[2JAlumno 1:");
        System.out.println("Nombre y apellido:\t"+alumno1.getNombre());
        System.out.println("Edad:\t"+alumno1.getEdad());
        System.out.println("Altura:\t"+alumno1.getAltura());
        System.out.println("---------------------------------");
        System.out.println("Alumno 2:");
        System.out.println("Nombre y apellido:\t"+alumno2.getNombre());
        System.out.println("Edad:\t"+alumno2.getEdad());
        System.out.println("Altura:\t"+alumno2.getAltura());


        if (alumno1.getEdad()>alumno2.getEdad()){
            System.out.println("El mayor de los dos alumnos es "+alumno1.getNombre());

        } else if(alumno2.getEdad()>alumno1.getEdad()) {
            System.out.println("El mayor de los dos alumnos es "+alumno2.getNombre());
        } else {
            System.out.println("Ambos alumnos tienen la misma edad.");

        }
    }

    public Alumno crearAlumno(){
        String nombre;
        int edad=0;
        double altura=0;
        boolean esNumero;
        Alumno alumno;

        do {
            System.out.println("Indique el nombre y el apellido del alumno/a:");
            nombre= lector.nextLine();
            if (nombre.length() < 5){
                System.out.println("Datos incorrectos intente de nuevo.");
            }
        }while(nombre.length() < 5);

        do {
            System.out.println("Indique la edad: ");
            esNumero= false;
            try{
                edad= lector.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("Debes introducir numeros, no letras.");
                esNumero=true;
            }finally {
                lector.nextLine();
            }

        }while(esNumero);

        do {
            System.out.println("Indique la altura: ");
            esNumero= false;
            try{
                altura= lector.nextDouble();
            }catch(InputMismatchException ime){
                System.out.println("Debes introducir numeros, no letras.");
                esNumero=true;
            }finally {
                lector.nextLine();
            }

        }while(esNumero);

        alumno= new Alumno(nombre,edad,altura);

        System.out.println("Alumno creado.\n");

        return alumno;
    }
}
