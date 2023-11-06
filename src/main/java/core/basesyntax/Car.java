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
        this.wheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            this.wheels.add(wheels.get(i).clone());
        }
        this.engine = (engine == null ? null : engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = getWheels();
        wheelList.add(newWheel);
        return new Car(year, color, wheelList, engine);
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloneWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            cloneWheels.add(wheels.get(i).clone());
        }
        return cloneWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && (color == car.color || color != null && color.equals(car.color))
                && (wheels == car.wheels || wheels != null && wheels.equals(car.wheels))
                && (engine == car.engine || engine != null && engine.equals(car.engine));
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 17 * hash + year;
        hash = 17 * hash + (color == null ? 0 : color.hashCode());
        hash = 17 * hash + (wheels == null ? 0 : wheels.hashCode());
        hash = 17 * hash + (engine == null ? 0 : engine.hashCode());
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
}
