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

    Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheelsCloning(wheels);
        this.engine = engineCloning(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsCloning(wheels);
    }

    public Engine getEngine() {
        return engineCloning(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels = new ArrayList<>(getWheels());
        wheels.add(wheel);
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> wheelsCloning(List<Wheel> wheels) {
        List<Wheel> wheelClone = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelClone.add(wheel.clone());
        }
        return wheelClone;
    }

    private Engine engineCloning(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass().equals(Car.class)) {
            Car current = (Car) o;
            return this.year == current.year
                    && this.color.equals(current.color)
                    && this.wheels.equals(current.wheels)
                    && this.engine.equals(current.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getYear();
        result = 31 * result + (getColor() == null ? 0 : getColor().hashCode());
        result = 31 * result + (getWheels() == null ? 0 : getWheels().hashCode());
        result = 31 * result + (getEngine() == null ? 0 : getEngine().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + getYear()
            + ", color='" + getColor() + '\''
            + ", wheels=" + getWheels()
            + ", engine=" + getEngine()
            + '}';
    }
}
