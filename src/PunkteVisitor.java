public class PunkteVisitor extends FlipperElementVisitor {
    private int totalScore = 0;

    @Override
    public void visit(Slingshot slingshot) {
        totalScore += slingshot.getHits() * 100; // 100 Punkte pro Treffer
        System.out.println("Punkte von Slingshot: " + (slingshot.getHits() * 100));
    }

    @Override
    public void visit(Target target) {
        if (target.isHit()) {
            totalScore += 200; // Punkte für ein getroffenes Target
        }
    }

    @Override
    public void visit(Bumper bumper) {
        totalScore += bumper.getPoints();
        System.out.println("Punkte von Bumper: " + bumper.getPoints());
    }

    public int getTotalScore() {
        return totalScore;
    }
}
