package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int i) {
        this.horsePower = i;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
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
        try {
            Engine clone = (Engine) super.clone();
            clone.setHorsePower(horsePower);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Engine", e);
        }
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
        return this.horsePower == engine.horsePower
                && this.manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
