package com.cinthyasophia.tema09.ejercicio08;

public class Ejercicio08 {

    private ArithmeticException ArithmeticException = new ArithmeticException();
    private NullPointerException NullPointerException = new NullPointerException();
    private IndexOutOfBoundsException IndexOutOfBoundsException = new IndexOutOfBoundsException();

    public Ejercicio08(){
        exceptions();
    }

    public void exceptions(){
        try{
            throw ArithmeticException;

        } catch (ArithmeticException e) {
            System.out.println("Operacion imposible de realizar.");
        }

        try{
            throw NullPointerException;

        } catch (NullPointerException npe){
            System.out.println("Posicion vacia.");

        }
        try{
            throw IndexOutOfBoundsException;

        } catch (IndexOutOfBoundsException iobe){
            System.out.println("Rango no existente.");

        }

    }

}
