package core.basesyntax;

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

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create a copy of object!", e);
        }
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getManufacturer() {
        return this.manufacturer;
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
            return this.getHorsePower() == current.getHorsePower()
                    && this.getManufacturer().equals(current.getManufacturer());
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + manufacturer.hashCode();
        return result;
    }
}
