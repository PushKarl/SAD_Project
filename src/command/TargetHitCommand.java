package command;

import command.Command;
import elemente.Target;
import main.Flipperautomat;
import zustand.EndState;

public class TargetHitCommand implements Command {
    private final Target target;
    private final Flipperautomat automat;

    public TargetHitCommand(Target target, Flipperautomat automat) {
        this.target = target;
        this.automat = automat;
    }

    public void execute() {
        if (automat.getAktuellerZustand() instanceof EndState) {
            System.out.println("Aktion nicht möglich: Das Spiel ist vorbei. Bitte werfen Sie eine neue Münze ein.");
            return;
        }
        target.hit();
    }
}
