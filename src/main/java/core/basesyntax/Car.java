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
        ArrayList<Wheel> copyArray = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyArray.add(wheel.clone());
        }
        this.wheels = copyArray;
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        ArrayList<Wheel> copyArray = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyArray.add(wheel.clone());
        }
        return copyArray;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        ArrayList<Wheel> newArray = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newArray.add(wheel.clone());
        }
        newArray.add(newWheel.clone());
        return new Car(this.year, this.color, newArray, this.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Car)
                && (Objects.equals(((Car) obj).color, color)
                && Objects.equals(((Car) obj).year, year)
                && Objects.equals(((Car) obj).wheels, wheels)
                && Objects.equals(((Car) obj).engine, engine));
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant clone object of Car", e);
        }
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
