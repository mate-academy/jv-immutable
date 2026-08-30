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
    protected Engine clone() {
        try {
            Engine clonedEngine = (Engine) super.clone();
            clonedEngine.setHorsePower(this.horsePower);
            clonedEngine.setManufacturer(this.manufacturer);
            return clonedEngine;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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

        if (horsePower != engine.horsePower) {
            return false;
        }
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
}
