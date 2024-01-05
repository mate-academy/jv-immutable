package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == null) {
            return false;
        }

        if (this == engine) {
            return true;
        }

        if (this.getClass() != engine.getClass()) {
            return false;
        }

        Engine current = (Engine) engine;
        return (Objects.equals(horsePower, current.horsePower))
                && (Objects.equals(manufacturer, current.manufacturer));
    }

    @Override
    public int hashCode() {
        int value = 17;
        value = 31 * value * horsePower;
        value = 31 * value * (manufacturer == null ? 0 : manufacturer.hashCode());
        return value;
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
