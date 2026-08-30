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

    public Engine setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Engine setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Engine object", e);
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
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + horsePower;
        hash = 31 * hash + (manufacturer == null ? 0 : manufacturer.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null && obj == null) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Engine.class)) {
            Engine current = (Engine) obj;
            return (horsePower == current.horsePower)
                    && (Objects.equals(current.manufacturer, manufacturer));
        }
        return false;
    }
}
