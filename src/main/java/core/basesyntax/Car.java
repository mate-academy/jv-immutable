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
        List<Wheel> deepCopyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            deepCopyWheels.add(wheel.clone());
        }
        this.wheels = deepCopyWheels;
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopyWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            deepCopyWheels.add(wheel.clone());
        }
        return deepCopyWheels;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car newYear(int newYear) {
        return new Car(newYear, this.color, this.wheels, this.engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(this.wheels);
        newWheelsList.add(newWheel);
        return new Car(this.year, this.color, newWheelsList, this.engine);
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

    @Override
    public Car clone() {
        Engine engineClone = this.engine.clone();
        List<Wheel> wheelsClone = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            wheelsClone.add(wheel.clone());
        }
        return new Car(this.year, this.color, wheelsClone, engineClone);
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
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}
