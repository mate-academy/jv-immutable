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
        this.wheels = copyWheel(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel);
        return car;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheel(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> copyWheel(List<Wheel> list) {
        List<Wheel> listOfWheel = new ArrayList<>();
        for (Wheel wheel : list) {
            listOfWheel.add(wheel.clone());
        }
        return listOfWheel;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 13 + year;
        result = result * 13 + (engine == null ? 0 : engine.hashCode());
        result = result * 13 + (color == null ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car currentCar = (Car) car;
            return year == currentCar.year
                    && Objects.equals(engine, currentCar.engine)
                    && Objects.equals(color, currentCar.color);
        }
        return false;
    }
}
