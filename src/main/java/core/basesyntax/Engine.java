package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    //implement this class

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int hashCode() {
        return (Objects.hashCode(horsePower) + Objects.hashCode(manufacturer)) * 7;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(Engine.class)) {
            Engine engine = (Engine) obj;
            return (engine.getHorsePower() == this.getHorsePower()
                    && engine.getManufacturer() == this.getManufacturer())
                    || obj.hashCode() == this.hashCode();
        }
        return false;
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
}
