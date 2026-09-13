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
            throw new AssertionError(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower
                && manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(horsePower);
        result = 31 * result + manufacturer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Engine{horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + "'}";
    }
}
