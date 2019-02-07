package com.cinthyasophia.tema09.ejercicio09;

public class Ejercicio09 {

    public Ejercicio09() {
        try {
            myArithmeticException();
        } catch (MyArithmeticException mae) {
            System.out.println(mae.getMessage());
        }
        try {
            myNullPointerException();
        } catch (MyNullPointerException mnpe) {
            System.out.println(mnpe.getMessage());
        }
        try {
            myIndexOutOfBoundsException();
        } catch (MyIndexOutOfBoundsException miobe) {
            System.out.println(miobe.getMessage());
        }




    }

    public void myArithmeticException() throws MyArithmeticException{
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException ae) {
            throw new MyArithmeticException("No se puede realizar esta operacion.");
        }
    }

    public void myNullPointerException() throws MyNullPointerException{
        try {
            throw new NullPointerException();
        } catch (NullPointerException npe){
            throw new MyNullPointerException("ERROR DE PUNTERO.");
        }
    }

    public void myIndexOutOfBoundsException() throws MyIndexOutOfBoundsException{
        try{
            throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException iobe){
            throw new MyIndexOutOfBoundsException("FUERA DE RANGO.");
        }
    }

}
