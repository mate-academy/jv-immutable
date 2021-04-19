package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone for engine", e);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Engine newEngine = (Engine) object;
        return newEngine.manufacturer.equals(manufacturer) && newEngine.horsePower == horsePower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, horsePower);
    }
}
