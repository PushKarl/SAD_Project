package elemente;

import mediator.FlipperElementMediator;
import visitor.FlipperElementVisitor;

public class Target implements FlipperElement {
    private boolean isHit = false;
    private int hits = 0;
    private FlipperElementMediator mediator;

    public Target(FlipperElementMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void hit() {
        hits++;
        System.out.println("Target wurde getroffen! Treffer: " + hits);
        if (!isHit) {
            isHit = true;
        }
        if (mediator != null) {
            mediator.notify(this, "hit");
        }
    }



    @Override
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
    }
}
