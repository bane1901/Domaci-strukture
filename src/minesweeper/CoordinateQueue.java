package minesweeper;

public class CoordinateQueue {

    private static class Cvor {
        int red;
        int kolona;
        Cvor sljedeci;

        Cvor(int red, int kolona) {
            this.red = red;
            this.kolona = kolona;
            this.sljedeci = null;
        }
    }

    private Cvor pocetak;
    private Cvor kraj;

    public CoordinateQueue() {
        this.pocetak = null;
        this.kraj = null;
    }

    public void dodaj(int red, int kolona) {
        Cvor novi = new Cvor(red, kolona);
        if (kraj != null) {
            kraj.sljedeci = novi;
        }
        kraj = novi;
        if (pocetak == null) {
            pocetak = novi;
        }
    }

    public int[] uzmi() {
        if (pocetak == null) return null;
        int[] koordinate = {pocetak.red, pocetak.kolona};
        pocetak = pocetak.sljedeci;
        if (pocetak == null) {
            kraj = null;
        }
        return koordinate;
    }

    public boolean jeliPrazan() {
        return pocetak == null;
    }
}