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
        this.engine = (engine == null) ? null : engine.clone();
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
        return (this.engine == null) ? null : this.engine.clone();
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> newListWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListWheels.add(wheel.clone());
        }
        return newListWheels;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedWheels = cloneWheels(this.wheels);
        clonedWheels.add(newWheel);
        return new Car(year, color, clonedWheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    @Override
    public int hashCode() {
        int hash = year;
        hash = 17 * hash + (color != null ? color.hashCode() : 0);
        hash = 17 * hash + (wheels != null ? wheels.hashCode() : 0);
        hash = 17 * hash + (engine != null ? engine.hashCode() : 0);
        return hash;
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
        if (year != car.year || !Objects.equals(color, car.color)
                || !Objects.equals(wheels, car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
    }
}
