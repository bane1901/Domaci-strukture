package minesweeper;




public class Cell {

    private boolean mina;
    private CellState stanje;
    private int brojSusjednihMina;

    public Cell() {
        this.mina = false;
        this.stanje = CellState.HIDDEN;
        this.brojSusjednihMina = 0;
    }

    public boolean jeMina() {
        return mina;
    }

    public void postaviMinu(boolean mina) {
        this.mina = mina;
    }

    public CellState getStanje() {
        return stanje;
    }

    public void setStanje(CellState stanje) {
        this.stanje = stanje;
    }

    public int getBrojSusjednihMina() {
        return brojSusjednihMina;
    }

    public void setBrojSusjednihMina(int broj) {
        this.brojSusjednihMina = broj;
    }
}