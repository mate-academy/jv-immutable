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

    public String getManufacturer() {
        return manufacturer;
    }

    // Повертає новий Engine із зміненою потужністю,
    // не змінюючи поточний об'єкт
    public Engine setHorsePower(int horsePower) {
        return new Engine(horsePower, this.manufacturer);
    }

    public Engine setManufacturer(String manufacturer) {
        return new Engine(this.horsePower, manufacturer);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Engine{");
        sb.append("horsePower=").append(horsePower)
                .append(", manufacturer='").append(manufacturer).append('\'')
                .append('}');
        return sb.toString();
    }

}
