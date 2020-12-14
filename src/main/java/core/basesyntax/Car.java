package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = addWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = getWheels();
        list.add(newWheel.clone());
        return new Car(year, color, list, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year &&
                Objects.equals(color, car.color) &&
                Objects.equals(wheels, car.wheels) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> addWheels(List<Wheel> list) {
        List<Wheel> assignWheels = new ArrayList<>();
        for (Wheel wheel : list) {
            assignWheels.add(wheel.clone());
        }
        return assignWheels;
    }
}
