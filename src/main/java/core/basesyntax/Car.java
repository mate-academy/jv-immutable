package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = engineClone(engine);
    }

    private Engine engineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> newWell = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            newWell.add(wheels.get(i).clone());
        }
        return newWell;
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
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCountersWheels = new Car(year, color, wheels, engine);
        newCountersWheels.wheels.add(newWheel);
        return newCountersWheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Car current = (Car) obj;
            return year == current.year
                    && Objects.equals(color,current.color)
                    && Objects.equals(wheels, current.wheels)
                    && Objects.equals(engine, current.engine);
        }
        return false;
    }
}
