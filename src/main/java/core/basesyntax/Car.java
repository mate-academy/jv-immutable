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
        this.wheels = new ArrayList<>();
        for (var element: wheels) {
            this.wheels.add(element.clone());
        }
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car changeColor(String newColor) {
        return new Car(year, new String(newColor), new ArrayList<>(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels1 = new ArrayList<>();
        for (var element: wheels) {
            wheels1.add(element.clone());
        }
        wheels1.add(newWheel.clone());
        return new Car(year, color, wheels1, engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, new ArrayList<>(wheels),
                new Engine(newEngine.getHorsePower(), newEngine.getManufacturer()));
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheels1 = new ArrayList<>();
        for (var element: wheels) {
            wheels1.add(element.clone());
        }
        return wheels1;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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
