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
        if (color == null) {
            throw new IllegalArgumentException("Color must not be null");
        }
        if (wheels == null) {
            throw new IllegalArgumentException("Wheels list must not be null");
        }
        if (engine == null){
            throw new IllegalArgumentException("Engine must not be null");
        }

        this.year = year;
        this.color = color;
        this.engine = engine.clone();
        this.wheels = cloneWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, cloneWheels(wheels), engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, cloneWheels(wheels), newEngine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = cloneWheels(wheels);
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine.clone());
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> cloned = new ArrayList<>();
        for (Wheel wheel : wheels) {
            cloned.add(wheel.clone());
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Objects.equals(color, car.color) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, engine, wheels);
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
}