package core.basesyntax;

public class Engine implements Cloneable {
    private static final int PRIME_NUMBER = 31;
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object engine) {
        if (this == engine) {
            return true;
        }
        if (engine == null || getClass() != engine.getClass()) {
            return false;
        }
        Engine current = (Engine) engine;
        return horsePower == current.horsePower
                && manufacturer.equals(current.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = PRIME_NUMBER * result + horsePower;
        result = PRIME_NUMBER * result + manufacturer.hashCode();
        return result;
    }

    @Override
    protected Engine clone() {
        return new Engine(horsePower, manufacturer);
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
}
