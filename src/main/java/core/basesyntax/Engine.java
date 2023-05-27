package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable{
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = Integer.valueOf(horsePower);
        this.manufacturer = String.valueOf(manufacturer);
    }

    public int getHorsePower() {
        return Integer.valueOf(horsePower);
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;

    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return String.valueOf(manufacturer);
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return getHorsePower() == engine.getHorsePower() && Objects.equals(getManufacturer(), engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorsePower(), getManufacturer());
    }

    @Override
    protected Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
