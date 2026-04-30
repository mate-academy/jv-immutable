package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    //implement this class

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int i) {
        this.horsePower = i;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
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
        try {
            return (Engine)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.horsePower == ((Engine) obj).horsePower
                && this.manufacturer == ((Engine) obj).manufacturer;
    }

    @Override
    public int hashCode() {
        int result = 31 * horsePower;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }
}
