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
        this.wheels = cloneWheelList(wheels);
        this.engine = engine == null ? engine : engine.clone();

    }

    public Car changeColor(String color) {
        return new Car(year, color, cloneWheelList(wheels), engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, cloneWheelList(wheels), engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = cloneWheelList(wheels);
        list.add(newWheel);
        return new Car(year, color, list, engine);
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && color.equals(car.color)
                && wheels.equals(car.wheels)
                && engine.equals(car.engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheelList(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private List<Wheel> cloneWheelList(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel:wheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }
}
