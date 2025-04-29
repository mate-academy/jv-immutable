package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheelList.add(wheel == null ? null : wheel.clone());
        }
        return copyWheelList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return new Car(this.year, this.color, this.getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return new Car(this.year, newColor, this.getWheels(), this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            throw new RuntimeException("Immutable objects should not be changed from outside");
        }
        List<Wheel> copyWheelList = new ArrayList<>(wheels);
        copyWheelList.add(newWheel);
        return new Car(this.year, this.color, copyWheelList, this.engine);
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        for (Wheel wheel : wheels) {
            result = 31 * result + wheel.hashCode();
        }
        result = 31 * result + engine.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass().equals(Car.class)) {
            Car car = (Car) obj;
            return car.year == year
                    && Objects.equals(car.color, color)
                    && car.engine.equals(engine)
                    && car.wheels.equals(wheels);
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

}
