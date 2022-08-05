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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
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
    public Engine clone() {
        Engine cloneEngine;
        try {
            cloneEngine = (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cloneEngine;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Engine engine = (Engine) object;
        return getHorsePower() == engine.getHorsePower() && getManufacturer().equals(engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorsePower(), getManufacturer());
    }
}
