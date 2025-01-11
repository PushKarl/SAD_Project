import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flipperautomat automat = new Flipperautomat();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Flipperelemente
        Slingshot slingshot = new Slingshot();
        Target target = new Target();

        // Befehle
        SlingshotHitCommand slingshotCommand = new SlingshotHitCommand(slingshot);
        TargetHitCommand targetCommand = new TargetHitCommand(target);

        // Liste der Flipperelemente
        List<FlipperElement> elements = new ArrayList<>();
        elements.add(slingshot);
        elements.add(target);

        System.out.println("Willkommen zum Flipperautomaten!");
        while (running) {
            System.out.println("\nWählen Sie eine Aktion:");
            System.out.println("1: Münze einwerfen");
            System.out.println("2: Startknopf drücken");
            System.out.println("3: Kugel verlieren");
            System.out.println("4: Slingshot treffen");
            System.out.println("5: Target treffen");
            System.out.println("6: Punkte berechnen");
            System.out.println("7: Elemente zurücksetzen");
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
                    PunkteVisitor punkteVisitor = new PunkteVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(punkteVisitor);
                    }
                    System.out.println("Gesamtpunkte: " + punkteVisitor.getTotalScore());
                    break;
                case "7":
                    ResetVisitor resetVisitor = new ResetVisitor();
                    for (FlipperElement element : elements) {
                        element.accept(resetVisitor);
                    }
                    System.out.println("Alle Elemente zurückgesetzt.");
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

