package adapter;

import command.Command;
import elemente.Rampe;

public class RampeAdapter implements Command {
    private Rampe rampe;

    public RampeAdapter(Rampe rampe) {
        this.rampe = rampe;
    }

    @Override
    public void execute() {
        System.out.println("Adapter: Aktivierung der Rampe wird ausgeführt.");

        // Die Rampe aktivieren
        rampe.activate();
    }
}
