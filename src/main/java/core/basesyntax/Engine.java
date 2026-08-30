package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
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
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone engine: ", e);
        }
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        result = 31 * result + horsePower;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(Engine.class)) {
            Engine engine = (Engine) obj;
            return engine.getHorsePower() == horsePower
                    && Objects.equals(engine.getManufacturer(), manufacturer);
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
}
