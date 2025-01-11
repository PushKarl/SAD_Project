public class PunkteVisitor extends FlipperElementVisitor {
    private int totalScore = 0;

    @Override
    public void visit(Slingshot slingshot) {
        totalScore += slingshot.getHits() * 100; // 100 Punkte pro Treffer
        System.out.println("Punkte von Slingshot: " + (slingshot.getHits() * 100));
    }

    public int getTotalScore() {
        return totalScore;
    }
}
