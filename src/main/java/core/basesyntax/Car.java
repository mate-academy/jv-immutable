package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        this.wheels = copiedWheels;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsListClone = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            wheelsListClone.add(wheel.clone());
        }
        return wheelsListClone;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(clone().year, clone().color, clone().wheels, otherMaker);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public Car changeColor(String blue) {
        return new Car(clone().year, blue, clone().wheels, clone().engine);
    }

    @Override
    protected Car clone() {
        try {
            List<Wheel> copiedWheels = new ArrayList<>();
            for (Wheel wheel : this.wheels) {
                copiedWheels.add(wheel.clone());
            }
            Engine copiedEngine = this.engine != null ? this.engine.clone() : null;
            return new Car(this.year, this.color, copiedWheels, copiedEngine);
        } catch (Exception e) {
            throw new RuntimeException("Can't clone car", e);
        }
    }
}
