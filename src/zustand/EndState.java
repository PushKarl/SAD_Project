package zustand;
import main.Flipperautomat;
import main.Main;

public class EndState implements Zustand {
    @Override
    public void muenzeEinwerfen(Flipperautomat automat) {
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
