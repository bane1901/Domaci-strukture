package minesweeper;

public class MyLinkedList {

    private NodeMove glava;

    public void dodajPotez(Move potez) {
        NodeMove novi = new NodeMove(potez);

        if (glava == null) {
            glava = novi;
            return;
        }

        NodeMove temp = glava;
        while (temp.sljedeci != null) {
            temp = temp.sljedeci;
        }
        temp.sljedeci = novi;
    }

    public NodeMove getGlava() {
        return glava;
    }
}