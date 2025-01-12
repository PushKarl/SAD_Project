package command;

public class RampeAktivierenCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Die Rampe wurde aktiviert!");
    }
}
