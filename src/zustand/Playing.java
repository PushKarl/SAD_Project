package zustand;

import display.TextStyle;
import display.TextStyleFactory;
import main.Flipperautomat;

public class Playing implements Zustand {
    private int kugelnVerloren = 0;
    private final int maxBälle = 3; // Maximale Anzahl von Bällen pro Münze

    public int getAktuellerBall() {
        return kugelnVerloren + 1; // Aktueller Ball ist verlorene Kugeln + 1
    }
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
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
            System.out.println(asciiStyle.format("GAME OVER! NEUE MÜNZE EINWERFEN!"));
            automat.setZustand(new EndState());
        } else {
            // ASCII-Ausgabe für verbleibende Bälle
            TextStyle asciiStyle = TextStyleFactory.getStyle("ASCII");
            System.out.println(asciiStyle.format("Verbleibende Bälle: " + (maxBälle - kugelnVerloren)));
        }
    }
}
