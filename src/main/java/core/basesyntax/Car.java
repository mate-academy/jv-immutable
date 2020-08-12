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
        List<Wheel> newWeelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWeelList.add(wheel.clone());
        }
        this.wheels = newWeelList;
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
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(wheels);
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car car = (Car) obj;
            return Objects.equals(color, car.color)
                    && Objects.equals(engine, car.engine)
                    && Objects.equals(wheels, car.wheels)
                    && Objects.equals(year, car.year);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 73 * result + year;
        result = 73 * result + (color == null ? 0 : color.hashCode());
        result = 73 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 73 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }
}
