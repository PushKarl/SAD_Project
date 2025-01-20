package elemente;

import visitor.FlipperElementVisitor;

public interface FlipperElement {
    void hit();

    void reset();

    void accept(FlipperElementVisitor visitor);
}
