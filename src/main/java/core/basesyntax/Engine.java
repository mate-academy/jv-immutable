package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine setHorsePower(int horsePower) {
        return new Engine(horsePower, manufacturer);
    }

    public Engine setManufacturer(String manufacturer) {
        return Objects.equals(this.manufacturer, manufacturer)
                ? this : new Engine(horsePower, manufacturer);
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
            throw new RuntimeException("Can't clone Engine", e);
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower
                && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

}
