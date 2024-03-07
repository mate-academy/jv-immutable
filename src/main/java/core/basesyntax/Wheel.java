package core.basesyntax;

public class Wheel {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel clone() {
        return new Wheel(this.radius);
    }
}
