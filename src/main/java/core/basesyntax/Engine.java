package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private final String manufacturer;
    private final int horsePower;

    public Engine(String manufacturer, int horsePower) {
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine engine)) return false;
        return horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer);
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
}
