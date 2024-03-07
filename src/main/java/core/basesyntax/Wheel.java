public class Wheel {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel withRadius(int newRadius) {
        return new Wheel(newRadius);
    }
}
