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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (object.getClass().equals(Engine.class)) {
            Engine engine = (Engine) object;
            return horsePower == engine.horsePower
                    && Objects.equals(manufacturer, engine.manufacturer);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result *= 29 + horsePower;
        result *= 29 + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone for Engine", e);
        }
    }
}
