package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private static final int PRIME_NUMBER_FOR_HASH_CODE = 17;
    private static final int PRIME_NUMBER_FOR_CALCULATE_HASH_CODE = 31;
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine otherEngine) {
        this.horsePower = otherEngine.horsePower;
        this.manufacturer = otherEngine.manufacturer;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Engine.class)) {
            Engine currentEngine = (Engine) o;
            return Objects.equals(horsePower, currentEngine.horsePower)
                    && Objects.equals(manufacturer, currentEngine.manufacturer);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = PRIME_NUMBER_FOR_HASH_CODE;
        result = PRIME_NUMBER_FOR_CALCULATE_HASH_CODE * result + horsePower;
        result = PRIME_NUMBER_FOR_HASH_CODE * result
                + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone Engine", e);
        }

    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
