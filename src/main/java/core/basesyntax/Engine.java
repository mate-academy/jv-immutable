package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    private Integer horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine engine) {
        this.horsePower = engine.getHorsePower();
        this.manufacturer = engine.getManufacturer();
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int newHorsePower) {
        this.horsePower = newHorsePower;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return Objects.equals(horsePower, engine.horsePower) && Objects.equals(manufacturer,
                engine.manufacturer);
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

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone of engine object", e);
        }
    }
}
