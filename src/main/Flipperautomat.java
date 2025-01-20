package main;

import display.TextStyle;
import display.TextStyleFactory;
import zustand.NoCredit;
import zustand.Zustand;
import zustand.EndState;
import zustand.Ready;
import zustand.Playing;

import elemente.*;
import visitor.*;
import mediator.FlipperElementMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flipperautomat {
    private Zustand aktuellerZustand;
    private int kredit = 0;
    private int totalPoints = 0;
    private Thread kugelVerlustThread;
    private String currentStyle = "Block";

    // Neue Felder für die Flipperelemente und Mediator
    private List<FlipperElement> flipperElemente = new ArrayList<>();
    private FlipperElementMediator mediator = new FlipperElementMediator();

    public Flipperautomat() {
        this.aktuellerZustand = new NoCredit();

        // Initialisiere Flipper-Elemente
        Slingshot slingshot = new Slingshot();
        Target target1 = new Target(mediator);
        Target target2 = new Target(mediator);
        Bumper bumper = new Bumper();
        Hole hole = new Hole();
        Rampe rampe = new Rampe();

        // Registriere Elemente beim Mediator
        mediator.registerElement(target1);
        mediator.registerElement(target2);
        mediator.registerElement(rampe);

        // Füge Elemente zur Liste hinzu
        flipperElemente.add(slingshot);
        flipperElemente.add(target1);
        flipperElemente.add(target2);
        flipperElemente.add(bumper);
        flipperElemente.add(hole);
        flipperElemente.add(rampe);
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
        if (aktuellerZustand instanceof Playing) {
            return ((Playing) aktuellerZustand).getAktuellerBall();
        }
        return 0;
    }

    public void muenzeEinwerfen() {
        kredit++;
        System.out.println("Münze eingeworfen. Aktueller Kredit: " + kredit);

        if (aktuellerZustand instanceof EndState) {
            setZustand(new Ready());
            System.out.println("Wechsel in den Ready-Zustand. Drei neue Bälle bereit.");
        } else {
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
        }
        aktuellerZustand.kugelVerlieren(this);
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
        totalPoints += points;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void startKugelVerlustThread() {
        if (kugelVerlustThread != null && kugelVerlustThread.isAlive()) {
            return;
        }

        kugelVerlustThread = new Thread(() -> {
            Random random = new Random();
            while (aktuellerZustand instanceof Playing) {
                try {
                    Thread.sleep(5000);
                    if (random.nextInt(10) < 2) {
                        System.out.println("Die Kugel ist RANDOM verloren gegangen!");
                        kugelVerlieren();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Kugelverlust-Thread wurde unterbrochen.");
                    Thread.currentThread().interrupt();
                }
            }
        });
        kugelVerlustThread.start();
    }

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
        TextStyle style = TextStyleFactory.getInstance().getStyle(currentStyle);
        System.out.println(style.format(message));
    }

    // Neue Methode: Simuliere Treffer auf alle Flipperelemente
    public void simulateHits() {
        System.out.println("Simuliere Treffer auf alle Flipperelemente:");
        for (FlipperElement element : flipperElemente) {
            element.hit();
        }
    }

    // Neue Methode: Punkte berechnen
    public void berechnePunkte() {
        PunkteVisitor punkteVisitor = new PunkteVisitor();
        for (FlipperElement element : flipperElemente) {
            element.accept(punkteVisitor);
        }
        System.out.println("Gesamtpunkte: " + punkteVisitor.getTotalScore());
        totalPoints += punkteVisitor.getTotalScore(); // Punkte zum Gesamtspielstand hinzufügen
    }

    // Neue Methode: Alle Elemente zurücksetzen
    public void resetElements() {
        ResetVisitor resetVisitor = new ResetVisitor();
        for (FlipperElement element : flipperElemente) {
            element.accept(resetVisitor);
        }
        System.out.println("Alle Flipperelemente wurden zurückgesetzt.");
    }
}
