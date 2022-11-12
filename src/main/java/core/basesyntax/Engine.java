package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private Integer horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        super();
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Engine(this.horsePower, this.manufacturer);
        }
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) o;
        return getHorsePower() == engine.getHorsePower()
                && Objects.equals(getManufacturer(), engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
