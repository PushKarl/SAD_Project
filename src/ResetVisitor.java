public class ResetVisitor extends FlipperElementVisitor {
    @Override
    public void visit(Slingshot slingshot) {
        System.out.println("Slingshot zurückgesetzt.");
        // Beispiel für einen Reset-Effekt, hier könntest du den Zustand anpassen
    }

    @Override
    public void visit(Target target) {
        target.reset(); // Setzt das Target zurück
        System.out.println("Target zurückgesetzt.");
    }
}
