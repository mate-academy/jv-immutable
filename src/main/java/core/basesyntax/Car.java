package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.wheels = wheelsClone(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel.clone());
        return car;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsClone(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
               && Objects.equals(color, car.color)
               && Objects.equals(wheels, car.wheels)
               && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> wheelsClone(List<Wheel> wheels) {
        List<Wheel> wheelsList = new ArrayList<>();
        for (Wheel wheel: wheels) {
            wheelsList.add(wheel.clone());
        }
        return wheelsList;
    }
}

