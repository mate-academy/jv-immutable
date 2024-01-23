package core.basesyntax;

public class Engine implements Cloneable {
    private Integer horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return Integer.valueOf(horsePower);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public Engine clone() {
        return new Engine(Integer.valueOf(horsePower), manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower && manufacturer.equals(engine.getManufacturer());
    }

    @Override
    public int hashCode() {
        int hash = 31;
        return hash * horsePower * manufacturer.hashCode();
    }
}
