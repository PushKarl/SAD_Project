package elemente;

import visitor.FlipperElementVisitor;

public abstract class FlipperElement {
    public abstract void accept(FlipperElementVisitor visitor);
}
