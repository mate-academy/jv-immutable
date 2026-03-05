package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable{
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine engine) {
        this.horsePower = engine.horsePower;
        this.manufacturer = engine.manufacturer;
    }

    public Engine withHorsePower(int horsePower) {
        return new Engine(horsePower, manufacturer);
    }

    public Engine withManufacturer(String manufacturer) {
        return new Engine(horsePower, manufacturer);
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Engine other = (Engine) obj;
        return horsePower == other.horsePower
                && Objects.equals(manufacturer, other.manufacturer);
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
            throw new RuntimeException(e);
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
