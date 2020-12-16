package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

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


    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("text");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
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
        int temphash = 17;
        temphash *= 31 + horsePower;
        temphash *= 31 + (manufacturer == null ? 0 : manufacturer.hashCode());
        return temphash;
    }
}
