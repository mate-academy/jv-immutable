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
    public int hashCode() {
        int result = 17;
        result = 31 * result + horsePower;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == this) {
            return true;
        }
        if (engine == null) {
            return false;
        }
        if (engine.getClass().equals(Engine.class)) {
            Engine current = (Engine) engine;
            return this.horsePower == current.horsePower
                    && (this.manufacturer == current.manufacturer
                    || (this.manufacturer != null
                    && this.manufacturer.equals(current.manufacturer)));
        }
        return false;
    }

    @Override
    public Engine clone() {
        try {
            Engine clonedEngine = (Engine) super.clone();
            clonedEngine.manufacturer = this.manufacturer;
            return clonedEngine;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone of Engine object cannot be created", e);
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
