package elemente;

import visitor.FlipperElementVisitor;

public class Rampe implements FlipperElement {

    @Override
    public void hit() {
        // Hier kannst du definieren, was passiert, wenn die Rampe getroffen wird
        System.out.println("Die Rampe wurde getroffen!");
    }

    @Override
    public void reset() {
        // Hier kannst du definieren, wie die Rampe zurückgesetzt wird
        System.out.println("Die Rampe wurde zurückgesetzt!");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);  // Aufruf der visit(Rampe)-Methode im Visitor
    }

    public void activate() {
        System.out.println("Die Rampe wurde aktiviert!");
    }
}
