package command;

import elemente.Bumper;

public class BumperHitCommand implements Command {
    private Bumper bumper;

    public BumperHitCommand(Bumper bumper) {
        this.bumper = bumper;
    }

    @Override
    public void execute() {
        bumper.hit();
    }
}

