package core.basesyntax;

import java.util.Objects;

public final class Engine {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(int newHorsePower){
        this.horsePower = newHorsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void  setManufacturer(String newManufacturer){
        this.manufacturer = newManufacturer;
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
        return Objects.equals(horsePower, engine.horsePower)
                && manufacturer.equals(engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }
}
