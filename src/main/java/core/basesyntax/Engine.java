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
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    protected Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public int hashCode() {
        int result = 3;
        result = horsePower * result;
        result = manufacturer.hashCode() * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Engine engine = (Engine) obj;
        if (engine == null) {
            return false;
        }
        return horsePower == engine.getHorsePower()
                && manufacturer.equals(engine.getManufacturer());
    }
}
