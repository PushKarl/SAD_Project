public class Slingshot extends FlipperElement {
    private int hits = 0;

    public void hit() {
        hits++;
        System.out.println("Slingshot getroffen! Trefferanzahl: " + hits);
    }

    public int getHits() {
        return hits;
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
