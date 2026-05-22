package minesweeper;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MatchDataset {

    private SortedSet<MatchSummary> mecevi;

    public MatchDataset() {
        mecevi = new TreeSet<>();
    }

    public void dodajMec(MatchSummary mec) {
        mecevi.add(mec);
    }

    public Double prosjecniKlikoviZaRezultat(String rezultat) {
        return mecevi.stream()
                .filter(m -> m.getRezultat().equals(rezultat))
                .mapToInt(MatchSummary::getUkupnoKlikova)
                .average()
                .orElse(0.0);
    }

    public MatchSummary mecSaNajvecimKlikRejom() {
        return mecevi.stream()
                .max(Comparator.comparing(m -> {
                    long vrijeme = m.getVrijemeMs();
                    if (vrijeme == 0) vrijeme = 1;
                    return (double) m.getUkupnoKlikova() / vrijeme;
                }))
                .orElse(null);
    }
}