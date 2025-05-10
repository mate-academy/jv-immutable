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
        return this.horsePower;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setHorsePower(int newHorsePower) {
        //return new Engine(newHorsePower, this.manufacturer);
        this.horsePower = newHorsePower;
    }

    public void setManufacturer(String newManufacturer) {
        //return new Engine(this.horsePower, newManufacturer);
        this.manufacturer = newManufacturer;
    }

    @Override
    public Engine clone() {
        return new Engine(this.horsePower, this.manufacturer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
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
