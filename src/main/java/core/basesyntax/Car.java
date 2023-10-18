package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getDeepCopyOfWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getDeepCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(wheels);
        newWheelsList.add(newWheel);
        return new Car(year, color, newWheelsList, engine);
    }

    @Override
    public int hashCode() {
        return 13 * Objects.hash(year) + Objects.hash(color)
                + Objects.hash(wheels) + Objects.hash(engine);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object.getClass().equals(getClass())) {
            Car current = (Car) object;
            return Objects.equals(current.year, this.year)
                    && Objects.equals(current.color, this.color)
                    && Objects.equals(current.wheels, this.wheels)
                    && Objects.equals(current.engine, this.engine);
        }

        return false;
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

    private List<Wheel> getDeepCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }
}
