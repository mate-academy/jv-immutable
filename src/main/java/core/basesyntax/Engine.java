package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    /**
     *  Implement this class.
     */
    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Engine clone() {
      try {
          return (Engine) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new RuntimeException();
      }
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
        if (horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower="
            + horsePower
            + ", manufacturer='"
            + manufacturer
            + '\''
            + '}';
    }
}
