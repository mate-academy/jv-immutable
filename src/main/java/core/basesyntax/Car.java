package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */

public final class Car {
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
        List<Wheel> wheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        this.wheels = wheelList;
        engine = engine == null ? null : engine.clone();
        this.engine = engine;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> arrayList = new ArrayList<>();
        arrayList.addAll(wheels);
        arrayList.add(wheel);
        return new Car(this.year, this.color, arrayList, this.engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public String getColor() {
        return color;
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

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    public int getYear() {
        int y = year;
        return y;
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
                && (color == car.color) || (color != null && color.equals(car.color))
                && (wheels == car.wheels) || (wheels != null && wheels.equals(car.wheels))
                && (engine == car.engine) || (engine != null && engine.equals(car.engine));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + year;
        return result;
    }
}
