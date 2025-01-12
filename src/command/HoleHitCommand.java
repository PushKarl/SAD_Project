package command;

import elemente.Hole;
import main.Flipperautomat;
import zustand.EndState;

public class HoleHitCommand implements Command {
    private Hole hole;
    private Flipperautomat automat;

    public HoleHitCommand(Hole hole, Flipperautomat automat) {
        this.hole = hole;
        this.automat = automat;
    }

    @Override
    public void execute() {
        if (automat.getAktuellerZustand() instanceof EndState) {
            System.out.println("Aktion nicht möglich: Das Spiel ist vorbei. Bitte werfen Sie eine neue Münze ein.");
            return;
        }
        hole.hit(); // Ruft die Logik für das Hole auf
    }
}
