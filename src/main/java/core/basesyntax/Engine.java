package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine() {

    }

    public Engine(int horsePower, String manufacturer) {
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
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
            Engine clone = (Engine) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public int hashCode() {
        return this.horsePower + this.manufacturer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass().equals(Engine.class)) {
            Engine casted = (Engine) obj;
            if (casted.horsePower == this.horsePower && (
                    this.manufacturer == null && casted.manufacturer == null
                    || (this.manufacturer != null && this.manufacturer.equals(casted.manufacturer))
                )
            ) {
                return true;
            }
        }

        return false;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
