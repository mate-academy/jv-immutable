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
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone");
        }

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
        return this.horsePower == current.horsePower
                && (this.manufacturer == current.manufacturer
                || (this.manufacturer != null && this.manufacturer.equals(current.manufacturer)));
    }

    @Override
    public int hashCode() {
        int primeNumber = 17;
        primeNumber = 31 * primeNumber + (manufacturer == null ? 0 : manufacturer.hashCode());
        primeNumber = 31 * primeNumber + horsePower;
        return primeNumber;
    }

}
