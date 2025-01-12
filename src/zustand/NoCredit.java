package zustand;

import display.TextStyle;
import display.TextStyleFactory;
import main.Flipperautomat;

import zustand.Zustand;

public class NoCredit implements Zustand {
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Wechsel zu Ready-Zustand.");
        automat.setZustand(new Ready());
        System.out.println("PRESS START");
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
