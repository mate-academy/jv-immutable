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
        try {
            this.wheels = getCopy(wheels);
            if (engine == null) {
                this.engine = null;
            } else {
                this.engine = engine.clone();
            }
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create copy of engine", e);
        }
    }

    private List<Wheel> getCopy(List<Wheel> list) throws CloneNotSupportedException {
        List<Wheel> wheelsCopy = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
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
        return year == car.year && color.equals(car.color)
                && wheels.equals(car.wheels) && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        try {
            return getCopy(wheels);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }

    public Car changeEngine(Engine engine) {
        try {
            Car car = new Car(year, color, getCopy(wheels), engine);
            return car;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Car changeColor(String newColor) {
        try {
            Car car = new Car(year, newColor, getCopy(wheels), engine.clone());
            return car;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Car addWheel(Wheel newWheel) {
        try {
            List<Wheel> newWheels = getCopy(wheels);
            newWheels.add(newWheel);
            Car car = new Car(year, color, newWheels, engine.clone());
            return car;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
