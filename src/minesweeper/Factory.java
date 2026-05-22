package minesweeper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Factory {

    public static MatchSummary parsujLiniju(String linija) {
        String[] dijelovi = linija.split(",");

        return new MatchSummary(
                Integer.parseInt(dijelovi[0]),
                dijelovi[1],
                dijelovi[2],
                Long.parseLong(dijelovi[3]),
                Integer.parseInt(dijelovi[4])
        );
    }

    public static MatchDataset parsujFajl(String imeFajla) throws IOException {
        MatchDataset dataset = new MatchDataset();
        Scanner skener = new Scanner(new File(imeFajla));

        if (skener.hasNextLine())
            skener.nextLine();

        while (skener.hasNextLine()) {
            String linija = skener.nextLine();
            MatchSummary mec = parsujLiniju(linija);
            dataset.dodajMec(mec);
        }

        skener.close();
        return dataset;
    }
}