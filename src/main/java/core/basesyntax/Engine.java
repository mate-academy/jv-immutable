package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    //implement this class
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
            throw new RuntimeException("Engine not cloned", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o != null || o.getClass() != Engine.class) {
            return false;
        }

        Engine current = (Engine) o;
        return (current != null && Objects.equals(this.horsePower, current.horsePower)
                && Objects.equals(this.manufacturer, current.manufacturer));
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer);
    }
}
