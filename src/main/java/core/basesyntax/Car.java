package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneList(wheels);
        this.engine = cloneEngine(engine);
    }

    private List<Wheel> cloneList(List<Wheel> wheels) {
        List<Wheel> tempList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            tempList.add(wheel == null ? null : wheel.clone());
        }
        return tempList;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneList(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(newWheel.clone());
        return newCar;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass().equals(Car.class)) {
            Car car = (Car) object;
            return year == car.year
                    && color == car.color || (color != null && color.equals(car.color))
                    && wheels == car.wheels || (wheels != null
                    && wheels.containsAll(car.wheels))
                    && engine == car.engine || (engine != null
                    && engine.equals(car.engine));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tempHash = 17;
        tempHash *= 31 + year;
        tempHash *= 31 + (color == null ? 0 : color.hashCode());
        tempHash *= 31 + (wheels == null ? 0 : wheels.hashCode());
        tempHash *= 31 + (engine == null ? 0 : engine.hashCode());
        return tempHash;
    }
}
