package command;

import elemente.Rampe;

public class RampeAdapter implements Command {
    private Rampe rampe;

    public RampeAdapter(Rampe rampe) {
        this.rampe = rampe;
    }

    @Override
    public void execute() {
        // Die Rampe wird aktiviert, indem der Befehl über den Adapter ausgeführt wird
        rampe.activate();
    }
}
