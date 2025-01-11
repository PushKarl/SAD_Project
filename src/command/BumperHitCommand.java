package command;

import elemente.Bumper;
import main.Flipperautomat;
import zustand.EndState;

public class BumperHitCommand implements Command {
    private final Bumper bumper;
    private final Flipperautomat automat;

    public BumperHitCommand(Bumper bumper, Flipperautomat automat) {
        this.bumper = bumper;
        this.automat = automat;
    }

    @Override
    public void execute() {
        if (automat.getAktuellerZustand() instanceof EndState) {
            System.out.println("Aktion nicht möglich: Das Spiel ist vorbei. Bitte werfen Sie eine neue Münze ein.");
            return;
        }
        bumper.hit();
    }
}
