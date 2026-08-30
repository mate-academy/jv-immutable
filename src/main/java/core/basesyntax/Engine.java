package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass().equals(Engine.class)) {
            Engine current = (Engine) o;
            return horsePower == current.horsePower
                    && manufacturer.equals(current.manufacturer);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getHorsePower();
        result = 31 * result + (getManufacturer() == null ? 0 : getManufacturer().hashCode());
        return result;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone engine.", e);
        }
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + getHorsePower()
            + ", manufacturer='" + getManufacturer() + '\''
            + '}';
    }
}
