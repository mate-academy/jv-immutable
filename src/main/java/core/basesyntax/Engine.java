package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer != null ? manufacturer : "";
    }

    public Engine(Engine other) {
        this(other.horsePower, other.manufacturer);
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int setHorsePower) {
        this.horsePower = setHorsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant clone Engine", e);
        }
    }

    public void setManufacturer(String setManufacturer) {
        this.manufacturer = setManufacturer;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower
                && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
