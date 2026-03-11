package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable{
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine engine) {
        this.horsePower = engine.horsePower;
        this.manufacturer = engine.manufacturer;
    }

//    public Engine withHorsePower(int horsePower) {
//        return new Engine(horsePower, manufacturer);
//    }
//
//    public Engine withManufacturer(String manufacturer) {
//        return new Engine(horsePower, manufacturer);
//    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    protected Engine clone() {
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
