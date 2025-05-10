package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {

    private int horsePower;
    private String manufacturer;

    Engine(int horsePower, String manufacturer) {
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
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Engine engine = (Engine) o;
            return horsePower == engine.horsePower && manufacturer.equals(engine.manufacturer);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public Engine clone() {
        Engine cloned;
        try {
            cloned = (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        cloned.manufacturer = manufacturer;
        cloned.horsePower = horsePower;
        return cloned;
    }
}
