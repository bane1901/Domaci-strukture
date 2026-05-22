package minesweeper;

import java.util.Random;

public class Board {

    private Cell[][] tabla;
    private int velicina;
    private int brojMina;

    public Board(int velicina, int brojMina) {
        if (velicina <= 0) {
            throw new IllegalArgumentException("Velicina mora biti pozitivna!");
        }
        if (brojMina < 0 || brojMina >= velicina * velicina) {
            throw new IllegalArgumentException("Neispravan broj mina!");
        }

        this.velicina = velicina;
        this.brojMina = brojMina;
        this.tabla = new Cell[velicina][velicina];

        inicijalizujTablu();
        postaviMine();
        izracunajSusjede();
    }

    private void inicijalizujTablu() {
        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                tabla[i][j] = new Cell();
            }
        }
    }

    private void postaviMine() {
        Random random = new Random();
        int postavljeno = 0;

        while (postavljeno < brojMina) {
            int i = random.nextInt(velicina);
            int j = random.nextInt(velicina);

            if (!tabla[i][j].jeMina()) {
                tabla[i][j].postaviMinu(true);
                postavljeno++;
            }
        }
    }

    private void izracunajSusjede() {
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1,  0,  1, -1, 1, -1, 0, 1};

        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                if (tabla[i][j].jeMina()) continue;

                int brojac = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (ni >= 0 && ni < velicina && nj >= 0 && nj < velicina) {
                        if (tabla[ni][nj].jeMina()) {
                            brojac++;
                        }
                    }
                }
                tabla[i][j].setBrojSusjednihMina(brojac);
            }
        }
    }

    public void otkrijPolje(int red, int kol) {
        if (red < 0 || red >= velicina || kol < 0 || kol >= velicina) return;
        if (tabla[red][kol].getStanje() != CellState.HIDDEN) return;

        tabla[red][kol].setStanje(CellState.REVEALED);

        if (tabla[red][kol].jeMina()) return;
        if (tabla[red][kol].getBrojSusjednihMina() != 0) return;

        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1,  0,  1, -1, 1, -1, 0, 1};

        CoordinateQueue red_ = new CoordinateQueue();
        red_.dodaj(red, kol);

        while (!red_.jeliPrazan()) {
            int[] trenutno = red_.uzmi();
            int r = trenutno[0];
            int k = trenutno[1];

            for (int d = 0; d < 8; d++) {
                int ni = r + di[d];
                int nj = k + dj[d];

                if (ni >= 0 && ni < velicina && nj >= 0 && nj < velicina) {
                    if (tabla[ni][nj].getStanje() == CellState.HIDDEN && !tabla[ni][nj].jeMina()) {
                        tabla[ni][nj].setStanje(CellState.REVEALED);
                        if (tabla[ni][nj].getBrojSusjednihMina() == 0) {
                            red_.dodaj(ni, nj);
                        }
                    }
                }
            }
        }
    }

    public GameOutcome getStanjeIgre() {
        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                if (tabla[i][j].jeMina() && tabla[i][j].getStanje() == CellState.REVEALED) {
                    return GameOutcome.DEFEAT;
                }
            }
        }
        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                if (!tabla[i][j].jeMina() && tabla[i][j].getStanje() != CellState.REVEALED) {
                    return GameOutcome.IN_PROGRESS;
                }
            }
        }
        return GameOutcome.VICTORY;
    }

    public Cell getPolje(int i, int j) {
        return tabla[i][j];
    }

    public int getVelicina() {
        return velicina;
    }
}