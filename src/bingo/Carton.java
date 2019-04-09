package bingo;

import java.util.ArrayList;

public class Carton {
    private final ArrayList<Integer> numeros;
    public Carton(Integer... n) {
        this.numeros = new ArrayList<>();
        for(Integer i : n) { this.numeros.add(i); }
    }

    //Funciones de Consulta
    public int getTamaño() { return this.numeros.size(); }
    public ArrayList<Integer> getNumeros() { return new ArrayList<>(this.numeros); }
}
