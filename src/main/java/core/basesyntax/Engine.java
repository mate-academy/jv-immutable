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

    @Override
    protected Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Engine engine = (Engine) object;
        return getHorsePower() == engine.getHorsePower() && Objects.equals(getManufacturer(),
            engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        int result = getHorsePower();
        result = 31 * result + Objects.hashCode(getManufacturer());
        return result;
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
}
