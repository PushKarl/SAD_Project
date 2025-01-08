
public class Playing implements Zustand {
    private int kugelnVerloren = 0;

    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Münze eingeworfen. Kredit erhöht.");
    }

    @Override
    public void startKnopfDrucken(Flipperautomat automat) {
        System.out.println("Entwickler: Software-Autoren! Das Spiel läuft bereits.");
    }

    @Override
    public void kugelVerlieren(Flipperautomat automat) {
        kugelnVerloren++;
        System.out.println("Kugel verloren. Verlorene Kugeln: " + kugelnVerloren);
        if (kugelnVerloren == 3) {
            System.out.println("Drei Kugeln verloren. Wechsel zu EndState.");
            automat.setZustand(new EndState());
        }
    }
}
