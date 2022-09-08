package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("The list is empty");
        }
        this.year = year;
        this.color = color;
        this.wheels = getWheelsListDeepCopy(wheels);
        this.engine = getEngineDeepCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsListDeepCopy(wheels);
    }

    public Engine getEngine() {
        return getEngineDeepCopy(engine);
    }

    private List<Wheel> getWheelsListDeepCopy(List<Wheel> wheelList) {
        return wheelList == null ? null
                : wheelList.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList());
    }

    private Engine getEngineDeepCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engineToChange) {
        return new Car(year, color, wheels, engineToChange);
    }

    public Car changeColor(String colorToChange) {
        return new Car(year, colorToChange, wheels, engine);
    }

    public Car addWheel(Wheel wheelToAdd) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheelToAdd);
        return new Car(year, color, newWheels, engine);
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
