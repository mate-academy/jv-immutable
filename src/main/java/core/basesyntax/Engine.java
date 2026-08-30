package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(final int horsePower, final String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    private Engine(final Engine engine) {
        this.horsePower = engine.horsePower;
        this.manufacturer = engine.manufacturer;
    }

    public void setHorsePower(final int newHorsePower) {
        this.horsePower = newHorsePower;
    }

    public void setManufacturer(final String newManufacturer) {
        this.manufacturer = newManufacturer;

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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Engine engine = (Engine) o;

        if (horsePower != engine.horsePower) {
            return false;
        }
        return manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = horsePower;
        result = 31 * result + manufacturer.hashCode();
        return result;
    }

    @Override
    public Engine clone() {
        Engine clone;
        try {
            clone = (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone is not supported", e);
        }
        return new Engine(clone);
    }
}
