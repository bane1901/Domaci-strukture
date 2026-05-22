package minesweeper;

public class TestMatchesAnalysis {

    public static void main(String[] args) {

        try {
            MatchDataset dataset = Factory.parsujFajl("matches.csv");

            System.out.println("ANALIZA PODATAKA");

            Double prosjecnoPobjede = dataset.prosjecniKlikoviZaRezultat("VICTORY");
            Double prosjecnoPorazi = dataset.prosjecniKlikoviZaRezultat("DEFEAT");
            MatchSummary najboljiRej = dataset.mecSaNajvecimKlikRejom();

            System.out.println("Prosjecni klikovi za pobjedu: " + prosjecnoPobjede);
            System.out.println("Prosjecni klikovi za poraz: " + prosjecnoPorazi);
            System.out.println("Mec sa najvecim klik rejtingom: " + najboljiRej);

            System.out.println("================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}