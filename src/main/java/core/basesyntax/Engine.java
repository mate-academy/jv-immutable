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
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 19 + horsePower;
        result = result * 31 + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
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

            return engine.getHorsePower() == this.horsePower
                    && engine.getManufacturer().equals(this.manufacturer);
        }
        return false;
    }

    @Override
    public Engine clone() {
        return new Engine(this.horsePower, this.manufacturer);
    }
}
