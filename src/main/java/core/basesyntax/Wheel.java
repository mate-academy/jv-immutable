package core.basesyntax;

public class Wheel implements Cloneable {
    private int diameter;
    private int weight;

    public Wheel(int diameter, int weight) {
        this.diameter = diameter;
        this.weight = weight;
    }

    // Додатковий конструктор для тестів
    public Wheel(int diameter) {
        this(diameter, 0);
    }

    public int getRadius() {
        return diameter;
    }

    public Wheel changeRadius(int newRadius) {
        return new Wheel(newRadius, this.weight);
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "diameter="
                + diameter
                + ", weight="
                + weight
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Wheel wheel = (Wheel) obj;

        return diameter == wheel.diameter
                && weight == wheel.weight;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(diameter);
        result = 31 * result + Integer.hashCode(weight);
        return result;
    }
}
