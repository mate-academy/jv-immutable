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
        this.wheels = getWheelsClone(wheels);
        this.engine = getEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(wheels);
    }

    public Engine getEngine() {
        return getEngineClone(engine);
    }

    public Car changeEngine(Engine engine) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.engine.setHorsePower(300);
        newCar.engine.setManufacturer("Ferrari");
        return newCar;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(newWheel);
        return newCar;
    }

    private Engine getEngineClone(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    private List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> wheelClone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelClone.add(wheel.clone());
        }
        return wheelClone;
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
}
