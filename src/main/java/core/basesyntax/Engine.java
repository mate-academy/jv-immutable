package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    //implement this class
    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (horsePower != engine.horsePower) return false;
        return Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = horsePower;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
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
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
