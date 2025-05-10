package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = new String(manufacturer);
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return new String(manufacturer);
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object obj) {
        Engine objEngine = (Engine) obj;
        return objEngine != null
                && this.horsePower == objEngine.horsePower
                && Objects.equals(this.manufacturer, objEngine.manufacturer);
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
}
