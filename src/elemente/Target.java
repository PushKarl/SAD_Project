package elemente;

import elemente.FlipperElement;
import visitor.FlipperElementVisitor;

import java.util.Random;

public class Target extends FlipperElement {
    private boolean isHit = false;
    private int hits = 0;

    public void hit() {
        Random random = new Random();
        if (random.nextBoolean()) {
            isHit = true;
            hits++;
            System.out.println("Target wurde getroffen! Treffer: " + hits);
        } else {
            System.out.println("Target wurde nicht getroffen.");
        }
    }

    public void reset() {
        isHit = false;
        hits = 0;
        System.out.println("Target zurückgesetzt.");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isHit() {
        return isHit;
    }

    public int getHits() {
      return hits;
    };
}
