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
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object engine) {
        if (this == engine) {
            return true;
        }
        if (engine == null || Engine.class != engine.getClass()) {
            return false;
        }
        Engine otherEngine = (Engine) engine;
        return horsePower == otherEngine.horsePower
                && Objects.equals(manufacturer, otherEngine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
