package core.basesyntax;

import java.util.Objects;

public final class Wheel {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Self-check: Is it the same object?
        if (this == obj) {
            return true;
        }

        // 2. Null-check: Is the other object null?
        if (obj == null) {
            return false;
        }

        // 3. Type-check: Is the other object of the same class?
        // Using getClass() ensures strict class equality, while instanceof allows
        // subclasses.
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 4. Cast: Cast the object to the correct type
        Wheel other = (Wheel) obj;

        // 5. Field comparison: Compare significant fields
        // For primitive types, use ==.
        // For object types, use Objects.equals() to handle nulls gracefully.
        return this.radius == other.radius;

    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    public int getRadius() {
        return radius;
    }
}
