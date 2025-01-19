package elemente;

import visitor.FlipperElementVisitor;

public class Hole extends FlipperElement {
    private boolean isOpen = true;
    private int hits = 0;
    @Override
    public void hit() {
        hits++;
        System.out.println("Das Hole wurde getroffen! Treffer: " + hits);

        // Punktevergabe oder andere Aktionen hier ausführen
        System.out.println("500 Punkte wurden vergeben!");
        // Weitere Effekte wie Rampenaktivierung könnten hier ausgelöst werden
    }

    public int getHits() {
        return hits;
    };

    @Override
    public void reset() {
        hits = 0;
        isOpen = true; // Hole wird in den Anfangszustand versetzt
        System.out.println("Hole zurückgesetzt.");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this); // Ermöglicht das Durchlaufen durch einen Visitor
    }
}