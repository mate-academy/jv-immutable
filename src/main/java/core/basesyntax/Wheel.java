package core.basesyntax;

public class Wheel {
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }
}
