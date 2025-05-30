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
        this.engine = engine == null ? null : engine.clone();

        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null.");
        }

        List<Wheel> tempDeepCopyList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                tempDeepCopyList.add(wheel.clone());
            } else {
                tempDeepCopyList.add(null);
            }
        }
        this.wheels = tempDeepCopyList;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopyWheelsList = new ArrayList<>();

        for (Wheel wheel : wheels) {
            if (wheel != null) {
                deepCopyWheelsList.add(wheel.clone());
            } else {
                deepCopyWheelsList.add(null);
            }
        }
        return deepCopyWheelsList;
    }

    public Engine getEngine() {
        return this.engine == null ? null : this.engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(getWheels());

        if (newWheel != null) {
            newWheelsList.add(newWheel.clone());
        } else {
            newWheelsList.add(null);
        }

        return new Car(year, color, newWheelsList, engine);
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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
