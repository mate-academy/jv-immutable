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
        this.year = year;
        this.color = color;
        this.wheels = wheelsCopy(wheels);
        this.engine = engineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engineCopy(engine);
    }

    private Engine engineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> wheelsCopy(List<Wheel> wheels) {
        List<Wheel> wheelCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheel = new ArrayList<>(this.wheels);
        wheel.add(newWheel);
        return new Car(year, color, wheel, engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year,color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels,car.wheels)
                && Objects.equals(engine, car.engine);
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
