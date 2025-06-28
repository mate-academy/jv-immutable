package core.basesyntax;

import java.util.Objects;

public final class Engine implements Cloneable {
    
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
    
    public Engine setHorsePower(final int horsePower) {
        return new Engine(horsePower, manufacturer);
    }
    
    public Engine setManufacturer(final String manufacturer) {
        return new Engine(horsePower, manufacturer);
    }
    
    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Engine)) {
            return false;
        }
        Engine other = (Engine) obj;
        return horsePower == other.horsePower &&
                Objects.equals(manufacturer, other.manufacturer);
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
