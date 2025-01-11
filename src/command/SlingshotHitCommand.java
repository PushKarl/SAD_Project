package command;

import command.Command;
import elemente.Slingshot;
import main.Flipperautomat;
import zustand.EndState;

public class SlingshotHitCommand implements Command {
    private Slingshot slingshot;
    private Flipperautomat automat;

    public SlingshotHitCommand(Slingshot slingshot, Flipperautomat automat) {
        this.slingshot = slingshot;
        this.automat = automat;
    }

    @Override
    public void execute() {
        if (automat.getAktuellerZustand() instanceof EndState) {
            System.out.println("Aktion nicht möglich: Das Spiel ist vorbei. Bitte werfen Sie eine neue Münze ein.");
            return;
        }
        slingshot.hit();
        System.out.println("elemente.Slingshot getroffen! Punkte wurden vergeben.");
    }
}
