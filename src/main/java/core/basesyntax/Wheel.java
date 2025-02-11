package core.basesyntax;

import java.util.Objects;

public class Wheel {
    private String material;
    private int size;

    public Wheel(String material, int size) {
        this.material = material;
        this.size = size;
    }

    public boolean equals(Wheel wheel) {
        if (this == wheel) {
            return true;
        }

        if (wheel == null || getClass() != wheel.getClass()) {
            return false;
        }

        return size == wheel.size
                && Objects.equals(material, wheel.material);
    }

    public int hashCode() {
        return Objects.hash(material, size);
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "material='" + material + '\''
                + ", size=" + size
                + '}';
    }
}
