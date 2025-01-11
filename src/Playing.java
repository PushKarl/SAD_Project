public class Playing implements Zustand {
    private int kugelnVerloren = 0;
    private int maxBälle = 3; // Maximale Anzahl von Bällen pro Münze

    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Münze eingeworfen. Kredit erhöht.");
    }

    @Override
    public void startKnopfDrucken(Flipperautomat automat) {
        System.out.println("Entwickler: Marina, Tamara & Ricarda! Das Spiel läuft bereits.");
    }

    @Override
    public void kugelVerlieren(Flipperautomat automat) {
        kugelnVerloren++;
        System.out.println("Kugel verloren. Verlorene Kugeln: " + kugelnVerloren);

        // Überprüfen, ob alle Bälle verloren sind
        if (kugelnVerloren >= maxBälle) {
            // ASCII-Ausgabe für Spielende
            TextStyle asciiStyle = TextStyleFactory.getStyle("ASCII");
            System.out.println(asciiStyle.format("GAME OVER!"));
            automat.setZustand(new EndState());
        } else {
            // ASCII-Ausgabe für verbleibende Bälle
            TextStyle asciiStyle = TextStyleFactory.getStyle("ASCII");
            System.out.println(asciiStyle.format("Verbleibende Bälle: " + (maxBälle - kugelnVerloren)));
        }
    }
}
