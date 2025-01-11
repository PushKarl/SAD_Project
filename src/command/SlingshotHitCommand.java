package command;

import command.Command;
import elemente.Slingshot;

public class SlingshotHitCommand implements Command {
    private Slingshot slingshot;

    public SlingshotHitCommand(Slingshot slingshot) {
        this.slingshot = slingshot;
    }

    @Override
    public void execute() {
        slingshot.hit();
        System.out.println("elemente.Slingshot getroffen! Punkte wurden vergeben.");
    }
}
