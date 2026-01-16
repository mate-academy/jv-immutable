package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        this.engine = (engine != null) ? engine.clone() : null;
        if (wheels == null) {
            throw new NullPointerException("You should not set objects as null.");
        }
        List<Wheel> copied = wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toCollection(ArrayList::new));
        this.wheels = Collections.unmodifiableList(copied);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList());
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    public Car changeEngine(Engine otherMaker) {
        if(otherMaker != null) {
            return new Car(getYear(), getColor(), getWheels(), otherMaker);
        } else {
            throw new RuntimeException("The engine value could not be null");
        }
    }

    public Car addWheel(Wheel wheel) {
        if(wheel != null) {
            List<Wheel> carWheels = getWheels();
            carWheels.add(wheel);
            return new Car(getYear(), getColor(), carWheels, getEngine());
        } else {
            throw  new RuntimeException("The wheel value could not be null");
        }
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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
