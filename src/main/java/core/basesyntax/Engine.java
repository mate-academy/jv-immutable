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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Engine other = (Engine) o;

        return this.horsePower == other.horsePower
                && Objects.equals(manufacturer, other.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + this.horsePower
            + ", manufacturer='" + this.manufacturer + '\''
            + '}';
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot create clone of Engine object", e);
        }
    }
}
