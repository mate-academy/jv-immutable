package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
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
        if (engine == this) {
            return true;
        }

        if (engine == null) {
            return false;
        }

        if (engine.getClass().equals(Engine.class)) {
            Engine current = (Engine) engine;

            return this.horsePower == current.horsePower
                    && Objects.equals(this.manufacturer, current.manufacturer);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.horsePower;
        result = 31 * result + (this.manufacturer == null ? 0 : this.manufacturer.hashCode());

        return result;
    }
}
