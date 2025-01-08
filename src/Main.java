
public class Main {
    public static void main(String[] args) {
        Flipperautomat automat = new Flipperautomat();

        // Testablauf
        automat.startKnopfDrucken(); // Kein Kredit
        automat.muenzeEinwerfen();   // Wechsel zu Ready
        automat.startKnopfDrucken(); // Wechsel zu Playing
        automat.kugelVerlieren();    // 1 Kugel verloren
        automat.kugelVerlieren();    // 2 Kugeln verloren
        automat.kugelVerlieren();    // 3 Kugeln verloren, Wechsel zu EndState
        automat.muenzeEinwerfen();   // Wechsel zu Ready
    }
}
