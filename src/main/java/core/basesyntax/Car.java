package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;
    private final CarBuilder builder = new CarBuilder();

    public Car(final int year, final String color, final List<Wheel> wheels, final Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine != null ? engine.clone() : null;
        this.wheels = new ArrayList<>();
        for (final Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    private Car(final Car car) {
        this.year = car.year;
        this.color = car.color;
        this.engine = car.engine != null ? car.engine.clone() : null;
        this.wheels = new ArrayList<>();
        for (final Wheel wheel : car.wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheelsList = new ArrayList<>();
        for (final Wheel wheel : wheels) {
            newWheelsList.add(wheel.clone());
        }
        return newWheelsList;
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(final Engine newEngine) {
        return builder.setYear(year)
                .setColor(color)
                .setWheels(wheels)
                .setEngine(newEngine)
                .build();
    }

    public Car addWheel(final Wheel newWheel) {
        List<Wheel> newWheelsList = getWheels();
        newWheelsList.add(newWheel.clone());
        return builder.setYear(year)
                .setColor(color)
                .setWheels(newWheelsList)
                .setEngine(engine)
                .build();
    }

    public Car changeColor(final String newColor) {
        return builder.setYear(year)
                .setColor(newColor)
                .setWheels(wheels)
                .setEngine(engine)
                .build();
    }

    public int getYear() {
        return year;
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Car car = (Car) o;

        if (year != car.year) {
            return false;
        }
        if (!color.equals(car.color)) {
            return false;
        }
        if (!wheels.equals(car.wheels)) {
            return false;
        }
        return engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }

    @Override
    public Car clone() {
        Car clone;
        try {
            clone = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone is not supported",e);
        }
        return new Car(clone);
    }
}
