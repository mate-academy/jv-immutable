package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    Car addWheel(Wheel newWheel) {
        List<Wheel> newListWheels = getWheelCopy(wheels);
        newListWheels.add(newWheel);
        return new Car(year,color, newListWheels, engine);
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

    private List<Wheel> getWheelCopy(List<Wheel> wheels) {
        List<Wheel> copiedWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            copiedWheel.add(wheel.clone());
        }
        return copiedWheel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return Objects.equals(color, car.color) && year == car.year
                && Objects.equals(engine, car.engine) && Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int res = 17;
        res += 11 * res + year;
        res += 11 * res + (color == null ? 0 : color.hashCode());
        res += 11 * res + (engine == null ? 0 : engine.hashCode());
        res += 11 * res + (wheels == null ? 0 : wheels.hashCode());
        return res;
    }
}
