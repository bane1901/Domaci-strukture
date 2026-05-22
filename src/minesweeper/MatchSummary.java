package minesweeper;

public class MatchSummary implements Comparable<MatchSummary> {

    private int matchId;
    private String tipBota;
    private String rezultat;
    private long vrijemeMs;
    private int ukupnoKlikova;

    public MatchSummary(int matchId, String tipBota, String rezultat, long vrijemeMs, int ukupnoKlikova) {
        this.matchId = matchId;
        this.tipBota = tipBota;
        this.rezultat = rezultat;
        this.vrijemeMs = vrijemeMs;
        this.ukupnoKlikova = ukupnoKlikova;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getTipBota() {
        return tipBota;
    }

    public String getRezultat() {
        return rezultat;
    }

    public long getVrijemeMs() {
        return vrijemeMs;
    }

    public int getUkupnoKlikova() {
        return ukupnoKlikova;
    }

    @Override
    public int compareTo(MatchSummary drugi) {
        return Long.compare(this.vrijemeMs, drugi.vrijemeMs);
    }

    @Override
    public String toString() {
        return "Mec #" + matchId +
               " | Rezultat: " + rezultat +
               " | Vrijeme: " + vrijemeMs + "ms" +
               " | Klikova: " + ukupnoKlikova;
    }
}