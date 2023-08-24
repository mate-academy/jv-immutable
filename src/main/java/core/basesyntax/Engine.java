package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public Engine clone() {

        return new Engine(horsePower, manufacturer);
    }

    public void setHorsePower(int horsePower) {
        if (this.horsePower != 0) {
            this.horsePower = horsePower;
        }
    }

    public void setManufacturer(String manufacturer) {
        if (this.manufacturer != "") {
            this.manufacturer = manufacturer;
        }
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
        return horsePower == engine.horsePower && manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
