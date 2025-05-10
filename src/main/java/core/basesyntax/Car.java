package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.wheels = getDeepCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public static List<Wheel> getDeepCopy(List<Wheel> wheelList) {
        if (wheelList == null) {
            return Collections.emptyList();
        }
        List<Wheel> cloneList = new ArrayList<>();
        for (Wheel wheel : wheelList) {
            cloneList.add(wheel.clone());
        }
        return cloneList;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, getDeepCopy(this.wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getDeepCopy(wheels), this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheelCount = getDeepCopy(this.wheels);
        updatedWheelCount.add(newWheel);
        return new Car(this.year, this.color, updatedWheelCount, this.engine.clone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Car current)) {
            return false;
        }
        return Objects.equals(year, current.year)
                && Objects.equals(color, current.color)
                && Objects.equals(wheels, current.wheels)
                && Objects.equals(engine, current.engine);
    }

    @Override
    protected Car clone() {
        return new Car(this.year, this.color, getDeepCopy(wheels),
                this.engine != null ? this.engine.clone() : null);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getDeepCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
}
