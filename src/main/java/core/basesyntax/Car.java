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
        this.color = (color == null ? "" : new String(color));
        this.wheels = getNewWheelsList(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    private List<Wheel> getNewWheelsList(List<Wheel> wheels) {
        List<Wheel> newWheelsList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheelsList.add(wheel.clone());
        }
        return newWheelsList;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        //return color;
        return color == null ? null : new String(color);
    }

    public List<Wheel> getWheels() {
        return wheels == null ? null : getNewWheelsList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (car == null) {
            return false;
        }
        if (this == car) {
            return true;
        }
        if (!car.getClass().equals(Car.class)) {
            return false;
        }
        Car current = (Car) car;
        return year == current.year
                && (color == current.color || (color != null && color.equals(current.color)))
                && (wheels == current.wheels || (wheels != null && wheels.equals(current.wheels)))
                && (engine == current.engine || (engine != null && engine.equals(current.engine)));
    }

    @Override
    protected Car clone() {
        List<Wheel> newWheelList = (wheels == null ? null : new ArrayList<>(wheels));
        Engine newEngine = engine == null ? null : engine.clone();
        return new Car(year, color, newWheelList, newEngine);
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
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(wheels);
        newWheelsList.add(newWheel.clone());
        return new Car(this.year, this.color, newWheelsList, this.engine);
    }

}
