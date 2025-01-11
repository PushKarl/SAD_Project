package elemente;

import elemente.FlipperElement;
import visitor.FlipperElementVisitor;

public class Target extends FlipperElement {
    private boolean isHit = false;

    public void hit() {
        if (!isHit) {
            isHit = true;
            System.out.println("elemente.Target getroffen! Punkte erhalten.");
        } else {
            System.out.println("elemente.Target wurde bereits getroffen.");
        }
    }

    public void reset() {
        isHit = false;
        System.out.println("elemente.Target zurückgesetzt.");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isHit() {
        return isHit;
    }
}
