package core.basesyntax;

public class Engine implements Cloneable {
    private static final int PRIME = 59;
    private int horsePower;
    private String manufacturer;

    public Engine() {

    }

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Could not create clone of Engine object", e);
        }

    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        final Engine other = (Engine) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getHorsePower() != other.getHorsePower()) {
            return false;
        }
        final Object this$manufacturer = this.getManufacturer();
        final Object other$manufacturer = other.getManufacturer();
        if (
                this$manufacturer == null ? other$manufacturer != null :
                        !this$manufacturer.equals(other$manufacturer
                        )
        ) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Engine;
    }

    public int hashCode() {
        int result = 1;
        result = result * PRIME + this.getHorsePower();
        final Object $manufacturer = this.getManufacturer();
        result = result * PRIME + ($manufacturer == null ? 43 : $manufacturer.hashCode());
        return result;
    }
}
