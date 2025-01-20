package mediator;

import elemente.FlipperElement;
import elemente.Rampe;
import elemente.Target;
import java.util.ArrayList;
import java.util.List;

public class FlipperElementMediator implements FlipperMediator {
    private List<FlipperElement> elements = new ArrayList<>();
    private List<Target> targetGroup = new ArrayList<>();
    private Rampe rampe;

    @Override
    public void registerElement(FlipperElement element) {
        elements.add(element);
        if (element instanceof Target) {
            targetGroup.add((Target) element);
        }
        if (element instanceof Rampe) {
            rampe = (Rampe) element;
        }
    }

    @Override
    public void notifyElement(FlipperElement element) {
        // Wenn ein Target getroffen wird, prüfen wir, ob alle Targets getroffen wurden
        if (element instanceof Target) {
            checkTargetGroupStatus();
        }

    }

    private void checkTargetGroupStatus() {
        boolean allTargetsHit = targetGroup.stream().allMatch(Target::isHit);

        if (allTargetsHit) {
            // Wenn alle Targets getroffen wurden, aktivieren wir die Rampe
            if (rampe != null) {
                rampe.activate();
            }
        }
    }
}
