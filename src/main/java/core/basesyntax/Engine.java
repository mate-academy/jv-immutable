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
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || o.getClass() != Engine.class) {
            return false;
        } else if (this.horsePower == ((Engine) o).getHorsePower()
                && Objects.equals(this.manufacturer, ((Engine) o).getManufacturer())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return horsePower * 7 + manufacturer.hashCode();
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
