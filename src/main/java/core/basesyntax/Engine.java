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
    public Engine clone() {
        try {
            super.clone();
            return new Engine(horsePower, manufacturer);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't clone Engine object");
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
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Engine)) {
            return false;
        }

        Engine engine = (Engine) obj;
        return engine.horsePower == horsePower
            && engine.manufacturer.equals(manufacturer);
    }
}
