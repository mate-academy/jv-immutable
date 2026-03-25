package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private static final int PRIME = 59;
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(wheel);
        return newCar;
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        } else {
            return this.engine.clone();
        }
    }

    private static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return getCopy(this.wheels);
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car other = (Car) o;
        if (this.getYear() != other.getYear()) {
            return false;
        }
        final Object this$color = this.getColor();
        final Object other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) {
            return false;
        }
        final Object this$wheels = this.getWheels();
        final Object other$wheels = other.getWheels();
        if (this$wheels == null ? other$wheels != null : !this$wheels.equals(other$wheels)) {
            return false;
        }
        final Object this$engine = this.getEngine();
        final Object other$engine = other.getEngine();
        if (this$engine == null ? other$engine != null : !this$engine.equals(other$engine)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int result = 1;
        result = result * PRIME + this.getYear();
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        final Object $wheels = this.getWheels();
        result = result * PRIME + ($wheels == null ? 43 : $wheels.hashCode());
        final Object $engine = this.getEngine();
        result = result * PRIME + ($engine == null ? 43 : $engine.hashCode());
        return result;
    }
}
