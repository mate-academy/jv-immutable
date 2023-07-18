package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class Car implements Cloneable {
    private final int  year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels.size());
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
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeColor(String color) {
        Car changedCar = new Car(year, color, wheels, engine);
        return changedCar;
    }

    public Car changeEngine(Engine engine) {
        Car changedCar = new Car(year, color, wheels, engine);
        return changedCar;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        newWheels.addAll(wheels);
        newWheels.add(newWheel);
        Car changedCar = new Car(year, color, newWheels, engine);
        return changedCar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Car.class)) {
            return false;
        }
        Car current = (Car) obj;
        return Objects.equals(color, current.color)
                && Objects.equals(wheels, current.wheels)
                && Objects.equals(engine, current.engine)
                && year == current.year;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + year;
        result = result * 31 + (color == null ? 0 : color.hashCode());
        result = result * 31 + (wheels == null ? 0 : wheels.hashCode());
        result = result * 31 + (engine == null ? 0 : engine.hashCode());
        return result;
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
