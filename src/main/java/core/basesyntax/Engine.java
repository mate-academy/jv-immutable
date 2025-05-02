package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    //implement this class

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
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create a clone of Engine object", e);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        if (this.horsePower == ((Engine) object).horsePower
                && this.manufacturer.equals(((Engine) object).manufacturer)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return horsePower * manufacturer.hashCode();
    }

    public void setHorsePower(int newHP) {
        this.horsePower = newHP;
    }

    public void setManufacturer(String newMaker) {
        this.manufacturer = newMaker;
    }
}
