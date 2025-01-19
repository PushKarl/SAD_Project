package elemente;

import visitor.FlipperElementVisitor;

public class Hole extends FlipperElement {
    private int hits = 0;

    @Override
    public void hit() {
        hits++;
        System.out.println("Das Hole wurde getroffen! Treffer: " + hits);
        System.out.println("500 Punkte wurden vergeben!");
    }

    public int getHits() {
        return hits;
    }

    @Override
    public void reset() {
        hits = 0;
        System.out.println("Hole zurückgesetzt.");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
