package com.cinthyasophia.tema09.ejercicio06;

public class Ejercicio06 {
    public Ejercicio06(){
        int numero=2;
        int[] vector= {-2,-1,0,1,2};

        dividirEntreArray(numero,vector);


    }
    public void dividirEntreArray(int num, int[] vector){
        double resultado;
        int puntero=0;
        boolean isFull;
        do {
            isFull=false;
            try{
                if (puntero==vector.length){
                    isFull=true;
                }
                if (vector[puntero]!=0){
                    resultado=num/vector[puntero];
                    System.out.println(num+" / "+vector[puntero]+" = "+resultado);
                    puntero++;

                }else{
                    System.out.println("Una division entre cero no es posible.");

                }

            }catch (ArithmeticException ae){
                System.out.println("Una division entre cero no es posible.");
                puntero++;
            }

        }while(!isFull);

    }

}
