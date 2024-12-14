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
            Engine engineNew = (Engine) super.clone();
            return engineNew;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can not clone", e);
        }

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + ((manufacturer == null) ? 0
                : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Engine other = (Engine) obj;
            return horsePower == other.horsePower && Objects.equals(manufacturer, other.manufacturer);
        }
        return false;
    }

    public void setHorsePower(int i) {
        this.horsePower = i;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
    }
}
