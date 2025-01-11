package zustand;

import main.Flipperautomat;

import zustand.Zustand;

public class NoCredit implements Zustand {
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Münze eingeworfen. Wechsel zu zustand.Ready-zustand.Zustand.");
        automat.setZustand(new Ready());
    }

    @Override
    public void startKnopfDrucken(Flipperautomat automat) {
        System.out.println("Kein Kredit! Bitte eine Münze einwerfen.");
    }

    @Override
    public void kugelVerlieren(Flipperautomat automat) {
        System.out.println("Keine Kugel im Spiel. Bitte starten Sie ein neues Spiel.");
    }
}
