package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine() {

    }

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int hashCode() {
        int result = 17;
        result = result * 31 + horsePower;
        result = result * 31 + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    public boolean equals(Object engine) {
        if (this == engine) {
            return true;
        }
        if (engine == null) {
            return false;
        }

        if (engine.getClass().equals(Engine.class)) {
            Engine current = (Engine) engine;
            return this.horsePower == current.horsePower
                    && manufacturer != null && manufacturer.equals(current.manufacturer);
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

    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone engine ", e);
        }
    }
}
