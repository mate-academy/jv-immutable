package core.basesyntax;

import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = (engine != null) ? engine.clone() : null;
        this.wheels = Wheel.deepCloneList(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        return Wheel.deepCloneList(wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.getYear(), this.getColor(), this.getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.getYear(), newColor, this.getWheels(), this.getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = Wheel.deepCloneList(wheels);
        newWheels.add(newWheel);
        return new Car(this.getYear(), this.getColor(), newWheels, this.getEngine());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!Objects.equals(engine, car.engine)) {
            return false;
        }
        return Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
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
}
