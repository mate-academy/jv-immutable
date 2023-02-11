package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.wheels = deepCopyWheel(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public final List<Wheel> getWheels() {
        return deepCopyWheel(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, deepCopyWheel(wheels), engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheel1 = deepCopyWheel(wheels);
        newWheel1.add(newWheel);
        return new Car(year, color, newWheel1, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, deepCopyWheel(wheels), engine.clone());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Car other = (Car) obj;
        if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
            return false;
        }
        if ((this.wheels == null) ? (other.wheels != null) : !this.wheels.equals(other.wheels)) {
            return false;
        }
        if ((this.engine == null) ? (other.engine != null) : !this.engine.equals(other.engine)) {
            return false;
        }

        if (this.year != other.year) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return year + color.hashCode() + wheels.hashCode() + engine.hashCode();
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

    private List<Wheel> deepCopyWheel(List<Wheel> wh) {
        ArrayList<Wheel> result = new ArrayList<Wheel>();
        for (Wheel w : wh) {
            result.add(w.clone());
        }
        return result;
    }

}
