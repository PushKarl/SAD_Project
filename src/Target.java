public class Target extends FlipperElement {
    private boolean isHit = false;

    public void hit() {
        if (!isHit) {
            isHit = true;
            System.out.println("Target getroffen! Punkte erhalten.");
        } else {
            System.out.println("Target wurde bereits getroffen.");
        }
    }

    public void reset() {
        isHit = false;
        System.out.println("Target zurückgesetzt.");
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isHit() {
        return isHit;
    }
}
