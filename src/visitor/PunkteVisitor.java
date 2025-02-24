package visitor;

import elemente.Bumper;
import elemente.Slingshot;
import elemente.Target;
import elemente.Hole;
import visitor.FlipperElementVisitor;

public class PunkteVisitor extends FlipperElementVisitor {
    private int totalScore = 0;

    @Override
    public void visit(Slingshot slingshot) {
        totalScore += slingshot.getHits() * 100; // 100 Punkte pro Treffer
        System.out.println("Punkte von Slingshot: " + (slingshot.getHits() * 100));
    }

    @Override
    public void visit(Target target) {
        int pointsForTarget = target.getHits() * 200; // 200 Punkte pro Treffer
        totalScore += pointsForTarget;
        System.out.println("Punkte von Target: " + pointsForTarget);
    }
    @Override
    public void visit(Bumper bumper) {
        totalScore += bumper.getPoints();
        System.out.println("Punkte von Bumper: " + bumper.getPoints());
    }
    @Override
    public void visit(Hole hole) {
        totalScore += hole.getHits() * 500; // 500 Punkte pro Treffer
        System.out.println("Punkte von Hole: " + (hole.getHits() * 500));
    }
    public int getTotalScore() {
        return totalScore;
    }
}
