package minesweeper;

public class NodeMove {

    Move potez;
    NodeMove sljedeci;

    public NodeMove(Move potez) {
        this.potez = potez;
        this.sljedeci = null;
    }
}