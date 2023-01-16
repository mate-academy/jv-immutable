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
            throw new RuntimeException("Can't clone an engine: "+ this, e);
        }
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + horsePower;
        hash = 31 * hash + (manufacturer != null ? manufacturer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine e = (Engine) o;

        boolean manufacturerEquals = (this.manufacturer == null && e.manufacturer == null) ||
                (this.manufacturer != null && this.manufacturer.equals(e.manufacturer));

        return  manufacturerEquals && this.horsePower == e.horsePower;
    }
}
