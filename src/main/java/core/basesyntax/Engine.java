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

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot clone Engine", e);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer);
    }

    public void setHorsePower(int i) {
        this.horsePower = i;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
    }
}
