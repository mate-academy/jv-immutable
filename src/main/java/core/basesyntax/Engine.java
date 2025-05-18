package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    private final int horsePower;
    private final String manufacturer;

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

    @Override
    public Engine clone() {
        try {
            return(Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not suppotred", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Engine engine)) {
            return false;
        }
        return horsePower == engine.horsePower
                && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

}
