package mediator;

import elemente.Rampe;
import elemente.Target;
import elemente.FlipperElement;
import java.util.HashSet;
import java.util.Set;

public class FlipperElementMediator {
    private Set<Target> targets = new HashSet<>();
    private Rampe rampe;

    public Set<Target> getTargets() {
        return targets;
    }


    // Registrierung von Targets
    public void registerTarget(Target target) {
        targets.add(target);
        System.out.println("Target registriert: " + target);
    }


    // Registrierung der Rampe
    public void registerRampe(Rampe rampe) {
        this.rampe = rampe;
    }

    // Allgemeine Registrierungsmethode
    public void registerElement(FlipperElement element) {
        if (element instanceof Target) {
            registerTarget((Target) element);
        } else if (element instanceof Rampe) {
            registerRampe((Rampe) element);
        } else {
            System.out.println("Element " + element.getClass().getSimpleName() + " wird nicht unterstützt.");
        }
    }

    // Ereignisbehandlung
    public void notify(FlipperElement sender, String event) {
        System.out.println("Mediator: Event '" + event + "' von " + sender.getClass().getSimpleName() + " empfangen.");

        if (event.equals("hit") && targets.contains(sender)) {
            System.out.println(sender.getClass().getSimpleName() + " wurde getroffen.");
            checkAllTargetsHit();
        }
    }

    // Überprüft, ob alle Targets getroffen wurden
    private void checkAllTargetsHit() {
        boolean allHit = true;
        for (Target target : targets) {
            if (!target.isHit()) {
                allHit = false;
                break;
            }
        }

        if (allHit) {
            System.out.println("Alle Targets wurden getroffen! Die Rampe wird aktiviert.");
            if (rampe != null) {
                rampe.activate();
            }
        }
    }
}
