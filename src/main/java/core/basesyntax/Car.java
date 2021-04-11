package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
        this.wheels = createDeepCopeOfWheelsList(wheels);
        this.engine = createClonedEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return createDeepCopeOfWheelsList(wheels);
    }

    public Engine getEngine() {
        return createClonedEngine(engine);
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null || getClass() != car.getClass()) {
            return false;
        }
        Car current = (Car) car;
        return this.year == current.year
                && this.color.equals(current.color)
                && this.wheels.equals(current.wheels)
                && this.engine.equals(current.engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }

    protected Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), getEngine());
    }

    protected Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    protected Car addWheel(Wheel newWheel) {
        List<Wheel> deepCopyWheels = createDeepCopeOfWheelsList(wheels);
        deepCopyWheels.add(newWheel);
        return new Car(getYear(), getColor(), deepCopyWheels, getEngine());
    }

    private Engine createClonedEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> createDeepCopeOfWheelsList(List<Wheel> wheels) {
        List<Wheel> resultList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            resultList.add(wheel.clone());
        }
        return resultList;
    }
}
