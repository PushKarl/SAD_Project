import java.util.Random;
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
        Random random = new Random();
        if (random.nextInt(10) < 3) { // 30% Wahrscheinlichkeit, dass die Kugel unerwartet verloren geht
            System.out.println("Die Kugel ist unerwartet verloren gegangen!");
            // ASCII-Ausgabe für unerwarteten Verlust
            TextStyle asciiStyle = TextStyleFactory.getStyle("ASCII");
            System.out.println(asciiStyle.format("Unvorhergesehener Verlust!"));
            aktuellerZustand.kugelVerlieren(this);
        } else {
            aktuellerZustand.kugelVerlieren(this);
        }
    }
}
