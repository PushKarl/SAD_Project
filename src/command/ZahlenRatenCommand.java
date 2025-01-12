package command;

import java.util.Scanner;

public class ZahlenRatenCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int richtigeZahl = (int) (Math.random() * 3) + 1;

        System.out.println("Erraten Sie eine Zahl zwischen 1 und 3:");
        int eingegebeneZahl = scanner.nextInt();

        if (eingegebeneZahl == richtigeZahl) {
            System.out.println("Richtig geraten! Sie erhalten Bonuspunkte!");
        } else {
            System.out.println("Falsch geraten. Die richtige Zahl war: " + richtigeZahl);
        }
    }
}
