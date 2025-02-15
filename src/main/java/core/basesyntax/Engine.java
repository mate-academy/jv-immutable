package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    // Instead of a setter, use this to create a modified copy
    public Engine changeManufacturer(String newManufacturer) {
        return new Engine(this.horsePower, newManufacturer);
    }

    public Engine changeHorsePower(int newHorsePower) {
        return new Engine(newHorsePower, this.manufacturer);
    }

    @Override
    public Engine clone() {
        return new Engine(this.horsePower, this.manufacturer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Engine)) return false;
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower &&
                Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
