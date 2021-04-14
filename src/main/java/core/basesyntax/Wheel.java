package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t correctly copy Wheel", e);
        }
    }

    @Override
    public int hashCode() {
        return 17 * 13 + radius;
    }

    @Override
    public boolean equals(Object wheel) {
        if (wheel == this) {
            return true;
        }
        if (wheel == null) {
            return false;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            Wheel currentWheel = (Wheel) wheel;
            return radius == currentWheel.radius;
        }
        return false;
    }
}
