package main;

import command.*;
import display.TextStyle;
import display.TextStyleFactory;
import elemente.*;
import visitor.PunkteVisitor;
import visitor.ResetVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        Hole hole = new Hole();

        // Befehle
        SlingshotHitCommand slingshotCommand = new SlingshotHitCommand(slingshot, automat);
        TargetHitCommand targetCommand = new TargetHitCommand(target, automat);
        BumperHitCommand bumperCommand = new BumperHitCommand(bumper, automat);
        HoleHitCommand holeCommand = new HoleHitCommand(hole, automat);
        ZahlenRatenCommand zahlenRatenCommand = new ZahlenRatenCommand();
        RampeAktivierenCommand rampeCommand = new RampeAktivierenCommand();

        //Makrobefehl
        MacroCommand holeMacro = new MacroCommand();
        holeMacro.addCommand(holeCommand);
        holeMacro.addCommand(zahlenRatenCommand);
        holeMacro.addCommand(rampeCommand);

        // Liste der Flipperelemente
        List<FlipperElement> elements = new ArrayList<>();
        elements.add(slingshot);
        elements.add(target);
        elements.add(bumper);
        elements.add(hole);

        System.out.println("""
                Willkommen zum
                 ________ ___       ___  ________  ________  _______   ________    \s
                |\\  _____\\\\  \\     |\\  \\|\\   __  \\|\\   __  \\|\\  ___ \\ |\\   __  \\   \s
                \\ \\  \\__/\\ \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\   __/|\\ \\  \\|\\  \\  \s
                 \\ \\   __\\\\ \\  \\    \\ \\  \\ \\   ____\\ \\   ____\\ \\  \\_|/_\\ \\   _  _\\ \s
                  \\ \\  \\_| \\ \\  \\____\\ \\  \\ \\  \\___|\\ \\  \\___|\\ \\  \\_|\\ \\ \\  \\\\  \\|\s
                   \\ \\__\\   \\ \\_______\\ \\__\\ \\__\\    \\ \\__\\    \\ \\_______\\ \\__\\\\ _\\\s
                    \\|__|    \\|_______|\\|__|\\|__|     \\|__|     \\|_______|\\|__|\\|__|
                
                """);
        while (running) {
            System.out.println("\nWählen Sie eine Aktion:");
            System.out.println("1: Münze einwerfen");
            System.out.println("2: Startknopf drücken");
            System.out.println("3: Kugel verlieren");
            System.out.println("4: Slingshot treffen");
            System.out.println("5: Target treffen");
            System.out.println("6: Bumper treffen");
            System.out.println("7: Hole treffen");
            System.out.println("8: Punkte berechnen");
            System.out.println("9: Elemente zurücksetzen");
            System.out.println("10: Spielstatus anzeigen (ASCII-Ausgabe)");
            System.out.println("11: Spiel beenden (ASCII-Ausgabe)");
            System.out.println("12: Schriftstil ändern");
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
                    holeMacro.execute(); // Führt alle Aktionen des Holes aus
                    hole.hit();
                    break;
                case "8":
                    PunkteVisitor punkteVisitor = new PunkteVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(punkteVisitor);
                    }
                    System.out.println("Gesamtpunkte: " + punkteVisitor.getTotalScore());
                    break;
                case "9":
                    ResetVisitor resetVisitor = new ResetVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(resetVisitor);
                    }
                    System.out.println("Alle Elemente zurückgesetzt.");
                    break;

                case "10":
                    if (automat.getAktuellerZustand() instanceof zustand.Ready) {
                        automat.printMessage("PRESS START");
                    } else if (automat.getAktuellerZustand() instanceof zustand.Playing) {
                        automat.printMessage("BALL " + automat.getAktuellerBall());
                    } else if (automat.getAktuellerZustand() instanceof zustand.EndState) {
                        automat.printMessage("GAME OVER");
                    } else {
                        System.out.println("Unbekannter Spielstatus.");
                    }
                    break;

                case "11":
                    if (automat.getKredit() > 0) {
                        automat.reduzierenKredit();
                        TextStyle styleGameOver = TextStyleFactory.getStyle(currentStyle);
                        System.out.println(styleGameOver.format("GAME OVER"));
                        System.out.println("Aktueller Spielstand: " + automat.getTotalPoints()); // Gesamtpunkte anzeigen
                        System.out.println("Verbleibender Kredit: " + automat.getKredit()); // Verbleibender Kredit anzeigen
                        System.out.println("Bitte wählen Sie eine Aktion aus dem Menü.");
                    } else {
                        TextStyle styleGameOver = TextStyleFactory.getStyle(currentStyle);
                        System.out.println(styleGameOver.format("GAME OVER"));
                        System.out.println("Kein Kredit mehr verfügbar. Bitte werfen Sie eine neue Münze ein.");
                    }
                    running = false;
                    break;

                case "12":
                    Set<String> allowedStyles = TextStyleFactory.getAvailableStyles();
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("Wählen Sie einen Schriftstil: " + String.join(", ", allowedStyles));
                        String style = scanner.nextLine().trim();

                        if (allowedStyles.contains(style)) {
                            automat.setCurrentStyle(style);
                            automat.printMessage("Schriftstil geändert zu: " + style);
                            validInput = true;
                        } else {
                            System.out.println("Ungültige Eingabe. Erlaubte Schriftstile: " + String.join(", ", allowedStyles));
                        }
                    }
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

