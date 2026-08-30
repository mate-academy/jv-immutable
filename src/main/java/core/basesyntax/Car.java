package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getClonedWheels(wheels);
        this.engine = getClonedEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getClonedWheels(wheels);
    }

    public Engine getEngine() {
        return getClonedEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, getClonedEngine(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> oldWheels = getClonedWheels(wheels);
        oldWheels.add(newWheel);
        return new Car(year, color, oldWheels, engine);
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
        return year == car.year
                && (car.color != null && car.color.equals(color))
                && (car.wheels != null && car.wheels.equals(wheels))
                && car.engine != null && car.engine.equals(engine);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + year;
        hash = hash * prime + (color == null ? 0 : color.hashCode());
        hash = hash * prime + (wheels == null ? 0 : wheels.hashCode());
        hash = hash * prime + (engine == null ? 0 : engine.hashCode());
        return hash;
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

    private List<Wheel> getClonedWheels(List<Wheel> original) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel originalWheel : original) {
            if (originalWheel == null) {
                clonedWheels.add(null);
            } else {
                clonedWheels.add(originalWheel.clone());
            }
        }
        return clonedWheels;
    }

    private Engine getClonedEngine(Engine originalEngine) {
        if (originalEngine == null) {
            return null;
        }
        return originalEngine.clone();
    }
}
