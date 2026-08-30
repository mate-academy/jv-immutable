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
        this.engine = engine == null ? null : engine.clone();

        List<Wheel> tempList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            tempList.add(wheel.clone());
        }
        this.wheels = tempList;

    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> tempList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            tempList.add(wheel.clone());
        }
        return tempList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        Car car = (Car) obj;
        if (year != car.year) {
            return false;
        }
        if (!color.equals(car.color)) {
            return false;
        }
        if (!Objects.equals(wheels, car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
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

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = getWheels();
        newWheelList.add(newWheel);
        return new Car(getYear(), getColor(), newWheelList, getEngine());
    }
}
