package core.basesyntax;

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
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 17 * result + horsePower;
        result = 17 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == this) {
            return true;
        } else if (engine == null) {
            return false;
        }
        if (engine.getClass().equals(Engine.class)) {
            Engine en = (Engine) engine;
            return en.horsePower == this.horsePower && en.manufacturer.equals(this.manufacturer);
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
