package core.basesyntax;

import java.util.Objects;

public final class Engine {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int setHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower
                  && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }
}
