package zustand;
import main.Flipperautomat;

public interface Zustand {
    void muenzeEinwerfen(Flipperautomat automat);
    void startKnopfDrucken(Flipperautomat automat);
    void kugelVerlieren(Flipperautomat automat);
}
