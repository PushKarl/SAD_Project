package visitor;

import elemente.Bumper;
import elemente.Slingshot;
import elemente.Target;
import visitor.FlipperElementVisitor;

public class ResetVisitor extends FlipperElementVisitor {
    @Override
    public void visit(Slingshot slingshot) {
        System.out.println("elemente.Slingshot zurückgesetzt.");
        // Beispiel für einen Reset-Effekt, hier könntest du den zustand.Zustand anpassen
    }

    @Override
    public void visit(Target target) {
        target.reset(); // Setzt das elemente.Target zurück
        System.out.println("elemente.Target zurückgesetzt.");
    }

    @Override
    public void visit(Bumper bumper) {
        bumper.reset(); // Setzt das elemente.Target zurück
        System.out.println("elemente.Bumper zurückgesetzt.");
    }
}
