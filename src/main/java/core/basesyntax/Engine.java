package core.basesyntax;

import java.util.Objects;

public final class Engine {
    private final int horsePower;
    private final String manufacturer;

    // implement this class

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
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
        Engine other = (Engine) obj;

        // 5. Field comparison: Compare significant fields
        // For primitive types, use ==.
        // For object types, use Objects.equals() to handle nulls gracefully.
        return this.horsePower == other.horsePower
                &&
                Objects.equals(this.manufacturer, other.manufacturer);

    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
