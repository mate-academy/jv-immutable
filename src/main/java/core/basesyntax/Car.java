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
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(newWheel);
        return newCar;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (object.getClass().equals(Car.class)) {
            Car car = (Car) object;
            return year == car.year
                    && Objects.equals(color, car.color)
                    && Objects.equals(wheels, car.wheels)
                    && Objects.equals(engine, car.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result *= 29 + year;
        result *= 29 + (color == null ? 0 : color.hashCode());
        result *= 29 + (wheels == null ? 0 : wheels.hashCode());
        result *= 29 + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    private Engine cloneEngine(Engine engine) {
        return (engine == null ? null : engine.clone());
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> newWheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheelList.add(wheel == null ? null : wheel.clone());
        }
        return newWheelList;
    }
}
