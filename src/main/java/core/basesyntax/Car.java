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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;

        this.wheels = Wheel.getCopy(wheels);
        if ((engine == null)) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return Wheel.getCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
    //implement this class

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear()
                && getColor().equals(car.getColor()) && getWheels().equals(car.getWheels())
                && getEngine().equals(car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = Wheel.getCopy(wheels);
        newWheels.add(newWheel);
        return new Car(year,color,newWheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year,newColor,wheels,engine);
    }
}
