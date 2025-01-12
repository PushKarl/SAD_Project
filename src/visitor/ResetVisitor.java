package visitor;

import elemente.Bumper;
import elemente.Slingshot;
import elemente.Target;
import elemente.Hole;
import visitor.FlipperElementVisitor;

public class ResetVisitor extends FlipperElementVisitor {
    @Override
    public void visit(Slingshot slingshot) {
        slingshot.reset();
    }
    @Override
    public void visit(Target target) {
        target.reset();
    }

    @Override
    public void visit(Bumper bumper) {
        bumper.reset();
    }
    public void visit(Hole hole) {
        hole.reset();
    }
}
