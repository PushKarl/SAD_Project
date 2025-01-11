package zustand;
import main.Flipperautomat;
import zustand.Zustand;

public class Ready implements Zustand {
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Münze eingeworfen. Kredit erhöht.");
    }

    @Override
    public void startKnopfDrucken(Flipperautomat automat) {
        System.out.println("Spiel startet. Wechsel zu zustand.Playing-zustand.Zustand.");
        automat.setZustand(new Playing());
    }

    @Override
    public void kugelVerlieren(Flipperautomat automat) {
        System.out.println("Spiel ist noch nicht gestartet.");
    }
}
