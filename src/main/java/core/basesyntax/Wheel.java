package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
