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
        this.wheels = getDeepCopyOfWheels(wheels);
        this.engine = getEngine();
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
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return engine == null ? this
                : new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = new ArrayList<>(getWheels());
        newWheelList.add(newWheel);
        return new Car(getYear(), getColor(), newWheelList, getEngine());
    }

    private static List<Wheel> getDeepCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year
                    && (this.color == current.color
                    || (this.color != null && this.color.equals(current.color)))
                    && (this.wheels == current.wheels
                    || (this.wheels != null && this.wheels.equals(current.wheels)))
                    && (this.engine == current.engine
                    || (this.engine != null && this.engine.equals(current.engine)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
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
