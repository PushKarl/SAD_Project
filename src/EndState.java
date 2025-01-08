
public class EndState implements Zustand {
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
        System.out.println("Münze eingeworfen. Wechsel zu Ready-Zustand.");
        automat.setZustand(new Ready());
    }

    @Override
    public void startKnopfDrucken(Flipperautomat automat) {
        System.out.println("Spiel vorbei. Bitte eine neue Münze einwerfen.");
    }

    @Override
    public void kugelVerlieren(Flipperautomat automat) {
        System.out.println("Das Spiel ist vorbei. Bitte starten Sie ein neues Spiel.");
    }
}
