package main;

import command.BumperHitCommand;
import command.SlingshotHitCommand;
import command.TargetHitCommand;
import display.TextStyle;
import display.TextStyleFactory;
import elemente.Bumper;
import elemente.FlipperElement;
import elemente.Slingshot;
import elemente.Target;
import visitor.PunkteVisitor;
import visitor.ResetVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String currentStyle = "Block"; // Standard-Stil
    public static void main(String[] args) {
        Flipperautomat automat = new Flipperautomat();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        // Flipperelemente
        Slingshot slingshot = new Slingshot();
        Target target = new Target();
        Bumper bumper = new Bumper();

        // Befehle
        SlingshotHitCommand slingshotCommand = new SlingshotHitCommand(slingshot, automat);
        TargetHitCommand targetCommand = new TargetHitCommand(target, automat);
        BumperHitCommand bumperCommand = new BumperHitCommand(bumper, automat);

        // Liste der Flipperelemente
        List<FlipperElement> elements = new ArrayList<>();
        elements.add(slingshot);
        elements.add(target);
        elements.add(bumper);

        System.out.println("Willkommen zum Flipperautomaten!");
        while (running) {
            System.out.println("\nWählen Sie eine Aktion:");
            System.out.println("1: Münze einwerfen");
            System.out.println("2: Startknopf drücken");
            System.out.println("3: Kugel verlieren");
            System.out.println("4: Slingshot treffen");
            System.out.println("5: Target treffen");
            System.out.println("6: Bumper treffen");
            System.out.println("7: Punkte berechnen");
            System.out.println("8: Elemente zurücksetzen");
            System.out.println("9: Spielstatus anzeigen (ASCII-Ausgabe)");
            System.out.println("10: Spiel beenden (ASCII-Ausgabe)");
            System.out.println("11: Schriftstil ändern");
            System.out.println("0: Programm beenden");

            System.out.print("Eingabe: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    automat.muenzeEinwerfen();
                    break;
                case "2":
                    automat.startKnopfDrucken();
                    break;
                case "3":
                    automat.kugelVerlieren();
                    break;
                case "4":
                    slingshotCommand.execute();
                    break;
                case "5":
                    targetCommand.execute();
                    break;
                case "6":
                    bumperCommand.execute();
                    break;
                case "7":
                    PunkteVisitor punkteVisitor = new PunkteVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(punkteVisitor);
                    }
                    System.out.println("Gesamtpunkte: " + punkteVisitor.getTotalScore());
                    break;
                case "8":
                    ResetVisitor resetVisitor = new ResetVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(resetVisitor);
                    }
                    System.out.println("Alle Elemente zurückgesetzt.");
                    break;

                case "9":
                    if (automat.getAktuellerZustand() instanceof zustand.Ready) {
                        TextStyle styleReady = TextStyleFactory.getStyle(currentStyle);
                        System.out.println(styleReady.format("Press Start"));
                    } else if (automat.getAktuellerZustand() instanceof zustand.Playing) {
                        TextStyle stylePlaying = TextStyleFactory.getStyle(currentStyle);
                        System.out.println(stylePlaying.format("BALL " + automat.getAktuellerBall()));
                    } else if (automat.getAktuellerZustand() instanceof zustand.EndState) {
                        TextStyle styleEnd = TextStyleFactory.getStyle(currentStyle);
                        System.out.println(styleEnd.format("GAME OVER"));
                    } else {
                        System.out.println("Unbekannter Spielstatus.");
                    }
                    break;

                case "10":
                    TextStyle styleGameOver = TextStyleFactory.getStyle(currentStyle);
                    System.out.println(styleGameOver.format("GAME OVER"));
                    running = false;
                    break;

                case "11":
                    System.out.println("Wählen Sie einen Schriftstil: Block oder Slant");
                    currentStyle = scanner.nextLine();
                    System.out.println("Schriftstil geändert zu: " + currentStyle);
                    break;

                case "0":
                    System.out.println("Programm beendet. Auf Wiedersehen!");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
            }
        }

        scanner.close();
    }
}

