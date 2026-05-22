package minesweeper;

import java.io.FileWriter;
import java.io.IOException;

public class GamesSimulator {

    public static Player napraviIgraca(Board tabla) {
        return new Player(tabla);
    }

    public static void main(String[] args) {

        try {
            FileWriter pisac = new FileWriter("matches.csv");
            pisac.write("MatchId,BotType,Result,TimeMs,TotalClicks\n");

            for (int i = 1; i <= 1000; i++) {
                Board tabla = new Board(8, 3);
                Player igrac = napraviIgraca(tabla);

                long pocetak = System.currentTimeMillis();

                GameOutcome rezultat;
                do {
                    rezultat = igrac.odirajPotez();
                } while (rezultat == GameOutcome.IN_PROGRESS);

                long kraj = System.currentTimeMillis();
                long vrijemeMs = kraj - pocetak;

                int ukupnoKlikova = prebrojPoteze(igrac.getIstorija());

                pisac.write(i + ",RandomBot," + rezultat + "," + vrijemeMs + "," + ukupnoKlikova + "\n");
            }

            pisac.close();
            System.out.println("Gotovo! CSV fajl kreiran.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int prebrojPoteze(MyLinkedList lista) {
        int broj = 0;
        NodeMove trenutni = lista.getGlava();
        while (trenutni != null) {
            broj++;
            trenutni = trenutni.sljedeci;
        }
        return broj;
    }
}