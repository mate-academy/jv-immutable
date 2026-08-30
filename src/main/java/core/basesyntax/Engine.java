package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private static final int MAGIC_HASH_MULTIPLICATOR = 31;
    private static final int MAGIC_HASH_CONSTANT = 17;

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
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException " + e);
        }
        return null;
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return MAGIC_HASH_MULTIPLICATOR * MAGIC_HASH_CONSTANT + horsePower
                * MAGIC_HASH_MULTIPLICATOR * MAGIC_HASH_CONSTANT
                + (manufacturer == null ? 0 : manufacturer.hashCode());
    }
}
