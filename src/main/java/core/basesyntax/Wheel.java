package core.basesyntax;

import java.util.Objects;

public class Wheel {
    private final String material;

    public Wheel(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public Wheel clone() {
        return new Wheel(this.material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return Objects.equals(material, wheel.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material);
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "material='" + material + '\''
                + '}';
    }
}
