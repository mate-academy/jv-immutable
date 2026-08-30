package core.basesyntax;

import java.util.ArrayList;
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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        //if (year < 0) {
        //    throw new RuntimeException("Year cannot be less than zero");
        //}
        this.year = year;
        //if (color == null || "".equals(color)) {
        //    throw new RuntimeException("Color should be provided");
        //}
        this.color = color;

        validateWheels(wheels);

        this.wheels = makeWheelListCopy(wheels);

        //if (engine == null) {
        //    throw new RuntimeException("Engine should be defined");
        //}
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, getWheels(), newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel anotherWheel) {
        if (anotherWheel == null) {
            throw new NullPointerException("Null Engine object");
        }

        List<Wheel> newWheels = getWheels();
        newWheels.add(anotherWheel.clone());
        return new Car(this.year, this.color, newWheels, getEngine());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return makeWheelListCopy(wheels);
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    private List<Wheel> makeWheelListCopy(List<Wheel> original) {
        List<Wheel> listCopy = new ArrayList<>();
        if (original != null) {
            for (Wheel w: original) {
                listCopy.add(w.clone());
            }
        }
        return listCopy;
    }

    private void validateWheels(List<Wheel> newWheels) {
        if (newWheels == null) {
            throw new NullPointerException("Null Wheels list");
        }

        //if (newWheels.size() == 0) {
        //    throw new RuntimeException("Empty wheels list");
        //}
        //
        //Integer radius = null;
        //
        //for (Wheel wheel: newWheels) {
        //    if (wheel == null) {
        //        throw new NullPointerException("Null Wheel object in the Wheels list");
        //    }
        //    if (radius == null) {
        //        radius = wheel.getRadius();
        //    } else if (wheel.getRadius() != radius) {
        //        throw new RuntimeException("All wheels should be the same radius. Expected: "
        //                + radius + ", got: " + wheel.getRadius());
        //    }
        //}
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

        if (!Objects.equals(wheels, car.wheels)) {
            return false;
        }

        return Objects.equals(engine, car.engine);
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
