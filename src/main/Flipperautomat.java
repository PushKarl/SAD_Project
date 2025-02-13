package main;

import display.TextStyle;
import display.TextStyleFactory;
import zustand.NoCredit;
import zustand.Zustand;
import zustand.EndState;
import zustand.Ready;
import zustand.Playing;

import java.util.Random;
public class Flipperautomat {
    private Zustand aktuellerZustand;
    private int kredit = 0;
    private int totalPoints = 0;
    private Thread kugelVerlustThread;
    private String currentStyle = "Block";


    public Flipperautomat() {
        this.aktuellerZustand = new NoCredit();
    }
    public void setZustand(Zustand zustand) {
        this.aktuellerZustand = zustand;
        if (zustand instanceof Playing) {
            startKugelVerlustThread();
        } else {
            stopKugelVerlustThread();
        }
    }
    public Zustand getAktuellerZustand() {
        return aktuellerZustand;
    }

    public int getAktuellerBall() {
        // Falls der Zustand Playing ist, hole die aktuelle Ballnummer
        if (aktuellerZustand instanceof Playing) {
            return ((Playing) aktuellerZustand).getAktuellerBall();
        }
        return 0; // Kein gültiger Ball im anderen Zustand
    }

    public void muenzeEinwerfen() {
        kredit++;
        System.out.println("Münze eingeworfen. Aktueller Kredit: " + kredit);

        // Wechsel von EndState zu Ready
        if (aktuellerZustand instanceof EndState) {
            setZustand(new Ready());
            System.out.println("Wechsel in den Ready-Zustand. Drei neue Bälle bereit.");
        } else {
            // Übergibt die Logik an den aktuellen Zustand
            aktuellerZustand.muenzeEinwerfen(this);
        }
    }

    public void startKnopfDrucken() {
        if (aktuellerZustand instanceof zustand.EndState) {
            System.out.println("Das Spiel ist vorbei. Bitte werfen Sie eine neue Münze ein.");
            return;
        }
        aktuellerZustand.startKnopfDrucken(this);
    }

    public void kugelVerlieren() {
        if (aktuellerZustand instanceof zustand.EndState) {
            System.out.println("Keine Kugeln mehr. Bitte werfen Sie eine Münze ein.");
            return;
        } aktuellerZustand.kugelVerlieren(this);
    }
    public int getKredit() {
        return kredit;
    }

    public void reduzierenKredit() {
        if (kredit > 0) {
            kredit--;
        }
    }
    public void addPoints(int points) {
        totalPoints += points; // Punkte zum Gesamtspielstand hinzufügen
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void startKugelVerlustThread() {
        if (kugelVerlustThread != null && kugelVerlustThread.isAlive()) {
            return; // Thread läuft bereits
        }

        kugelVerlustThread = new Thread(() -> {
            Random random = new Random();
            while (aktuellerZustand instanceof Playing) {
                try {
                    Thread.sleep(5000); // Alle 5 Sekunden prüfen
                    if (random.nextInt(10) < 2) { // 20% Wahrscheinlichkeit
                        System.out.println("Die Kugel ist RANDOM verloren gegangen!");
                        kugelVerlieren(); // Kugel verlieren
                    }
                } catch (InterruptedException e) {
                    System.out.println("Kugelverlust-Thread wurde unterbrochen.");
                    Thread.currentThread().interrupt();
                }
            }
        });
        kugelVerlustThread.start();
    }

    // Stoppt den Thread, wenn der Zustand nicht mehr "Playing" ist
    public void stopKugelVerlustThread() {
        if (kugelVerlustThread != null && kugelVerlustThread.isAlive()) {
            kugelVerlustThread.interrupt();
        }
    }

    public String getCurrentStyle() {
        return currentStyle;
    }

    public void setCurrentStyle(String currentStyle) {
        this.currentStyle = currentStyle;
    }

    public void printMessage(String message) {
        TextStyle style = TextStyleFactory.getStyle(currentStyle);
        System.out.println(style.format(message));
    }
}
