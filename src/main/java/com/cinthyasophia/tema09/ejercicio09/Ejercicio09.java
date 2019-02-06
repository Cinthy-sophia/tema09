package com.cinthyasophia.tema09.ejercicio09;

public class Ejercicio09 {

    public Ejercicio09() {
        try {
            myArithmeticException();
        } catch (MyArithmeticException mae) {
            System.out.println(mae.getMessage());
        }



    }

    public void myArithmeticException() throws MyArithmeticException{
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException ae) {
            throw new MyArithmeticException("MI mensaje");
        }
    }

    public void myNullPointerException() throws MyNullPointerException{
        try {
            throw new NullPointerException();
        } catch (NullPointerException npe){
            throw new MyNullPointerException("ERROR DE PUNTERO.");
        }
    }

}
