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

    public void setHorsePower(int newHorsePower) {
        horsePower = newHorsePower;
    }

    public void setManufacturer(String newMaker) {
        manufacturer = newMaker;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    protected Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        } else {
            Engine engine = (Engine) object;
            return horsePower == engine.horsePower
                    && Objects.equals(manufacturer, engine.manufacturer);
        }
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
