package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyWheelsList(wheels);
        this.engine = copyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheelsList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            throw new NullPointerException("Passed argument is null");
        }
        Car newCar = this.clone();
        newCar.engine.setManufacturer(engine.getManufacturer());
        newCar.engine.setHorsePower(engine.getHorsePower());
        return newCar;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyWheelsList(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        if (engine == null) {
            throw new NullPointerException("Passed argument is null");
        }
        Car newCar = this.clone();
        newCar.wheels.add(newWheel.clone());
        return newCar;
    }

    @Override
    protected Car clone() {
        Car car = new Car(year, color, copyWheelsList(wheels), copyEngine(engine));
        return car;
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
        return year == car.year && color.equals(car.color)
                && wheels.equals(car.wheels) && engine.equals(car.engine);
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

    private List<Wheel> copyWheelsList(List<Wheel> wheels) {
        List<Wheel> listToReturn = new ArrayList<>();
        for (Wheel temp : wheels) {
            listToReturn.add(temp.clone());
        }
        return listToReturn;
    }

    private Engine copyEngine(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }
}
