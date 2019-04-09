package main;

import bingo.Bingo;
import bingo.Carton;

public class App {

    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        Carton c1 = bingo.generarCarton();
        System.out.println("Numeros del Carton 1");
        System.out.println(c1.getNumeros().toString());
        Carton c2 = bingo.generarCarton();
        System.out.println("Numeros del Carton 2");
        System.out.println(c2.getNumeros().toString());
        Carton c3 = bingo.generarCarton();
        System.out.println("Numeros del Carton 3");
        System.out.println(c3.getNumeros().toString());

        do {
            int bola = bingo.extraerBola();
            System.out.println("Bola Extraida: " + bola);
        } while (!bingo.finalizado());

        System.out.println("\nFin del Bingo!");
        if (bingo.comprobarCarton(c1)) {
            System.out.println("Carton 1 Ganador!");
        }

        if (bingo.comprobarCarton(c2)) {
            System.out.println("Carton 2 Ganador!");
        }

        if (bingo.comprobarCarton(c3)) {
            System.out.println("Carton 3 Ganador!");
        }
    }
}
