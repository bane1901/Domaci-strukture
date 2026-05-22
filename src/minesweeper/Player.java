package minesweeper;

import java.util.Random;

public class Player {

    private Board tabla;
    private MyLinkedList istorijaPoteza;
    private Random random;

    public Player(Board tabla) {
        this.tabla = tabla;
        this.istorijaPoteza = new MyLinkedList();
        this.random = new Random();
    }

    public GameOutcome odirajPotez() {
        int velicina = tabla.getVelicina();

        while (true) {
            int red = random.nextInt(velicina);
            int kol = random.nextInt(velicina);

            if (tabla.getPolje(red, kol).getStanje() == CellState.HIDDEN) {
                boolean bezbjedno = !tabla.getPolje(red, kol).jeMina();
                tabla.otkrijPolje(red, kol);

                Move potez = new Move(red, kol, bezbjedno);
                istorijaPoteza.dodajPotez(potez);

                return tabla.getStanjeIgre();
            }
        }
    }

    public MyLinkedList getIstorija() {
        return istorijaPoteza;
    }
}