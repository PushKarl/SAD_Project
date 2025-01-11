package command;

import command.Command;
import elemente.Target;

public class TargetHitCommand implements Command {
    private Target target;

    public TargetHitCommand(Target target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.hit();
    }
}
