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
    public int hashCode() {
        Integer horsePowerInteger = horsePower;
        int result = 17;
        result = 31 * result * (horsePowerInteger == null ? 0 : horsePowerInteger.hashCode());
        result = 31 * result * (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Integer horsePowerInteger = horsePower;
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj.getClass().equals(Engine.class)) {
            Engine current = (Engine) obj;
            return (horsePowerInteger == null ? current.getHorsePower() == 0
                    : horsePowerInteger.equals(current.getHorsePower()))
                    && (this.manufacturer == null ? current.getManufacturer() == null
                    : this.manufacturer.equals(current.getManufacturer()));
        }
        return false;
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
