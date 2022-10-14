package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    //implement this class
    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower && (manufacturer == engine.manufacturer
                || manufacturer != null && manufacturer.equals(engine.manufacturer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        result = 31 * result + horsePower;
        return result;
    }

    public void setHorsePower(int horsePower) {
        //return new Engine(horsePower, manufacturer);
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        //return new Engine(horsePower, manufacturer);
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        int hp = horsePower;
        return hp;
    }

    public String getManufacturer() {
        String str = manufacturer;
        return str;
    }

    @Override
    public Engine clone() {
        try {
            Engine clone = (Engine) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
