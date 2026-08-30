package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    //implement this class

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
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    public boolean equals(Object engine) {
        if (engine == this) {
            return true;
        }

        if (engine == null) {
            return false;
        }

        if (engine.getClass().equals(Engine.class)) {
            Engine current = (Engine) engine;
            return (this.horsePower == current.horsePower
                    && this.manufacturer.equals(current.manufacturer));
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public Engine clone() {
        try {
            Engine clone = (Engine) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of engine object", e);
        }
    }
}
