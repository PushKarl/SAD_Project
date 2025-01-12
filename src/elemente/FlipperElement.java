package elemente;

import visitor.FlipperElementVisitor;

public abstract class FlipperElement {
    public abstract void hit();

    public abstract void reset();

    public abstract void accept(FlipperElementVisitor visitor);
}
