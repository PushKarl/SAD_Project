package elemente;

import elemente.FlipperElement;
import visitor.FlipperElementVisitor;

public class Slingshot implements FlipperElement {
    private int hits = 0;

    public void hit() {
        hits++;
        System.out.println("Slingshot getroffen! Trefferanzahl: " + hits);
    }

    @Override
    public void reset() {
        hits = 0; // Treffer werden zurückgesetzt
        System.out.println("Slingshot zurückgesetzt.");
    }

    public int getHits() {
        return hits;
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
