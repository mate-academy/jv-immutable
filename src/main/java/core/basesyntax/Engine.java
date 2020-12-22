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
    public boolean equals(Object engine) {
        if (this == engine) {
            return true;
        }
        if (engine == null || getClass() != engine.getClass()) {
            return false;
        }
        Engine newEngine = (Engine) engine;
        return horsePower == newEngine.horsePower
                && Objects.equals(manufacturer, newEngine.manufacturer);
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
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone ", e);
        }
    }
}
