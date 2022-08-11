package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = (engine == null) ? null : engine.clone();
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return getCopyWheelList();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> wheels = getCopyWheelList();
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyWheelList(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = clone();
        newCar.wheels.add(newWheel.clone());
        return newCar;
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
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, engine);
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
    protected Car clone(){
        return new Car(year, color, getCopyWheelList(), engine.clone());
    }

    private List<Wheel> getCopyWheelList() {
        List<Wheel> tempWheels = new ArrayList<>(this.wheels.size());
        for (Wheel wheel : this.wheels) {
            tempWheels.add(wheel.clone());
        }
        return tempWheels;
    }
}
