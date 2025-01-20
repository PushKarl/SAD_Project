package visitor;

import elemente.Bumper;
import elemente.Slingshot;
import elemente.Target;
import elemente.Hole;
import elemente.Rampe;

public abstract class FlipperElementVisitor {
    public abstract void visit(Slingshot slingshot);
    public abstract void visit(Target target);
    public abstract void visit (Bumper bumper);
    public abstract void visit (Hole hole);
    public abstract void visit(Rampe rampe);


    // Weitere Flipperelemente können hier ergänzt werden
}
