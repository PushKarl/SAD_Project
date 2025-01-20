package mediator;

import elemente.FlipperElement;

public interface FlipperMediator {
    void registerElement(FlipperElement element);
    void notifyElement(FlipperElement element);
}

