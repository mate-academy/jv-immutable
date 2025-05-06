package core.basesyntax;

import java.util.Objects;

public record Engine(String manufacturer, int horsePower) {
    public Engine {
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("manufacturer can't be empty");
        }
        if (horsePower <= 0) {
            throw new IllegalArgumentException("horsePower must be greater than 0");
        }

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine engine)) {
            return false;
        }
        return horsePower == engine.horsePower
                && Objects.equals(manufacturer, engine.manufacturer);
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
