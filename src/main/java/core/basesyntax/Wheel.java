package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (!(wheel instanceof Wheel)) {
            return false;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            Wheel wheelOther = (Wheel) wheel;
            return ((radius == 0 && wheelOther.radius == 0)
                    || (radius != 0 && wheelOther.radius != 0
                    && radius == wheelOther.radius));
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        if (radius != 0) {
            result = prime * result + radius;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Wheel", e);
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
