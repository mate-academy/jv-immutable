package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

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
    public int hashCode() {
        int h = 17;
        h = 31 * h + horsePower;
        return 31 * h + ((manufacturer == null) ? 0 : manufacturer.hashCode());
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == null) {
            return false;
        }
        if (this == engine) {
            return true;
        }
        if (!this.getClass().equals(engine.getClass())) {
            return false;
        }
        Engine current = (Engine) engine;
        if (this.horsePower != current.horsePower) {
            return false;
        } else {
            return this.manufacturer.equals(current.manufacturer);
        }
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
