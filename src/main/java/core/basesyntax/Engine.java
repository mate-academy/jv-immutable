package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    //implement this class

    public Engine() {
    }

    public Engine(int horsePower, String manufacturer) {
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
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
    public int hashCode() {
        return this.horsePower + this.manufacturer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Engine engine = (Engine) obj;
        return (engine.horsePower == this.horsePower
                && (this.manufacturer == null && engine.manufacturer == null
                        || (this.manufacturer != null
                && this.manufacturer.equals(engine.manufacturer))));
    }

    @Override
    public Engine clone() {
        try {
            Engine clone = (Engine) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Can't create clone of Engine", e);
        }
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }
}
