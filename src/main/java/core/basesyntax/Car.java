package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    @Override
    protected Car clone() {
        return new Car(year,color,copyWheels(wheels),engine.clone());
    }

    public Car changeEngine(Engine engine) {
        Engine newEngine = engine.clone();
        return new Car(year,color,copyWheels(wheels),newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year,newColor,copyWheels(wheels),engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = new ArrayList<>(wheels.size() + 1);
        wheelList.addAll(copyWheels(wheels));
        wheelList.add(newWheel);
        return new Car(year,color,wheelList,engine.clone());
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> wheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;

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
