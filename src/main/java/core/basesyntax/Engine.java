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
    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == this) {
            return true;
        }
        if (engine == null || engine.getClass() != Engine.class) {
            return false;
        }
        Engine currentEngin = (Engine)engine;
        return Objects.equals(this.horsePower,currentEngin.horsePower)
                && Objects.equals(this.manufacturer,currentEngin.manufacturer);
    }

    @Override
    public Engine clone() {
        try {
            return (Engine)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported for engine");
        }
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
