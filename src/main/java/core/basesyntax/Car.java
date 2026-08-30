package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelsCopy(wheels);
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

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeColor(String newColor) {
        return new Car(year,newColor,wheels,engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        return new Car(year, color,newWheels, engine);
    }

    public Car changeEngine(Engine engine) {
        new Engine(engine);
        return new Car(year, color, wheels, engine);
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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car car) {
            return Objects.equals(year, car.year)
                    && Objects.equals(color, car.color)
                    && Objects.equals(engine, car.engine);
        }
        return false;
    }

    public List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> deepCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            deepCopy.add(wheel.copy());
        }
        return deepCopy;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone()); // Повертаємо копії
        }
        return copiedWheels;
    }

}
