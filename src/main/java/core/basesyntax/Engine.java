package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == null || engine.getClass() != this.getClass()) {
            return false;
        }
        Engine newEngine = (Engine) engine;
        if (this == engine) {
            return true;
        }
        return horsePower == newEngine.getHorsePower()
                && manufacturer.equals(newEngine.getManufacturer());
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += hashCode * horsePower;
        hashCode += hashCode * manufacturer.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
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
}
