package core.basesyntax;

import java.util.Objects;

public class Engine {
    private String type;
    private int power;

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public boolean equals(Engine engine) {
        if (this == engine) {
            return true;
        }

        if (engine == null || getClass() != engine.getClass()) {
            return false;
        }

        return power == engine.power
                && Objects.equals(type, engine.type);
    }

    public int hashCode() {
        return Objects.hash(type, power);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "type='" + type + '\''
                + ", power=" + power
                + '}';
    }
}
