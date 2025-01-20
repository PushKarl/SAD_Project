package command;

import elemente.Rampe;

public class RampeAdapter implements Command {
    private Rampe rampe;

    public RampeAdapter(Rampe rampe) {
        this.rampe = rampe;
    }

    @Override
    public void execute() {
        rampe.activate();
    }
}
