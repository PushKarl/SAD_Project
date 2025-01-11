package visitor;

import elemente.Bumper;
import elemente.Slingshot;
import elemente.Target;

public abstract class FlipperElementVisitor {
    public abstract void visit(Slingshot slingshot);
    public abstract void visit(Target target);
    public abstract void visit (Bumper bumper);





    // Weitere Flipperelemente können hier ergänzt werden
}
