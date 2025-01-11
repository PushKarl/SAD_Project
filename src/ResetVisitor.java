public class ResetVisitor extends FlipperElementVisitor {
    @Override
    public void visit(Slingshot slingshot) {
        slingshot.hit(); // Beispiel für einen Reset-Effekt
        System.out.println("Slingshot zurückgesetzt.");
    }
}
