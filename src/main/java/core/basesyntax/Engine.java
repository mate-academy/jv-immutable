package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine engine) {
        this.horsePower = engine.horsePower;
        this.manufacturer = engine.manufacturer;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) o;
        return getHorsePower() == engine.getHorsePower()
                && getManufacturer().equals(engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        int result = getHorsePower();
        result = 31 * getManufacturer().hashCode();
        return result;
    }

    @Override
    protected Engine clone() {
        return new Engine(this.horsePower, this.manufacturer);
    }
    //implement this class

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
