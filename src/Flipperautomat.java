
public class Flipperautomat {
    private Zustand aktuellerZustand;

    public Flipperautomat() {
        this.aktuellerZustand = new NoCredit();
    }

    public void setZustand(Zustand zustand) {
        this.aktuellerZustand = zustand;
    }

    public void muenzeEinwerfen() {
        aktuellerZustand.muenzeEinwerfen(this);
    }

    public void startKnopfDrucken() {
        aktuellerZustand.startKnopfDrucken(this);
    }

    public void kugelVerlieren() {
        aktuellerZustand.kugelVerlieren(this);
    }
}
