package bingo;

import java.util.ArrayList;

public class Bingo {

    private ArrayList<Integer> bombo;
    private ArrayList<Integer> bolasExtraidas;
    private ArrayList<Carton> cartones;
    private ArrayList<Carton> cartonesGanadores;

    //Constantes
    private final static int BOLA_MAYOR = 30;
    private final static int TAMAÑO_CARTON = 9;

    public Bingo() {
        this.bolasExtraidas = new ArrayList<>();
        this.cartones = new ArrayList<>();
        this.bombo = new ArrayList<>();
        this.cartonesGanadores = new ArrayList<>();
        for (int i = 1; i <= BOLA_MAYOR; i++) {
            this.bombo.add(i);
        }
    }

    //Funcionalidades
    public boolean finalizado() {
        return (this.bombo.isEmpty() || this.cartonesGanadores.size() > 1);
    }

    public boolean comprobarCarton(Carton c) {
        return this.bolasExtraidas.containsAll(c.getNumeros());
    }

    public Carton generarCarton() {
        ArrayList<Integer> numeros = new ArrayList<>(this.bombo);
        java.util.Collections.shuffle(numeros);
        ArrayList<Integer> numerosCarton = new ArrayList<>();
        for (int i = 1; i <= TAMAÑO_CARTON; i++) {
            int elem = numeros.get(0);
            numerosCarton.add(elem);
            numeros.remove(0);
        }

        Integer[] n = new Integer[numerosCarton.size()];
        for (int i = 0; i < numerosCarton.size(); i++) {
            n[i] = numerosCarton.get(i);
        }
        Carton c = new Carton(n);
        this.cartones.add(c);
        return c;
    }

    public int extraerBola() {
        if (!finalizado()) {
            java.util.Collections.shuffle(this.bombo);
            int elem = this.bombo.get(0);
            this.bombo.remove(0);
            this.bolasExtraidas.add(elem);
            for (Carton c : this.cartones) {
                if (comprobarCarton(c)) {
                    this.cartonesGanadores.add(c);
                    break;
                }
            }
            return elem;
        } else {
            return 0;
        }
    }
}
