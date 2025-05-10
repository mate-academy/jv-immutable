package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower
                && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return 31 * horsePower + manufacturer.hashCode();
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Engine setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Engine setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
