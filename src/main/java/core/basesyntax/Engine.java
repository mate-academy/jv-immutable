package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
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
        return Objects.equals(horsePower, engine.horsePower)
                && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorsePower(), getManufacturer());
    }

    @Override
    protected Engine clone() {
        try {
            Engine eng = (Engine) super.clone();
            return eng;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone an Engine object", e);
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
