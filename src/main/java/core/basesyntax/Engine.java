package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsepower;
    private String manufacturer;

    public Engine(int horsepower, String manufacturer) {
        this.horsepower = horsepower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsepower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
        return horsepower == engine.horsepower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsepower);
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone!", e);
        }
    }
}
