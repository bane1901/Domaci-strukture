package minesweeper;

public class Move {

    private int red;
    private int kolona;
    private boolean biloBezbjedno;

    public Move(int red, int kolona, boolean biloBezbjedno) {
        this.red = red;
        this.kolona = kolona;
        this.biloBezbjedno = biloBezbjedno;
    }

    public int getRed() {
        return red;
    }

    public int getKolona() {
        return kolona;
    }

    public boolean jeBezbjedno() {
        return biloBezbjedno;
    }
}