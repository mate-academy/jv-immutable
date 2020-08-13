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
        this.wheels = new ArrayList<>();
        fillList(wheels);
        this.engine = initEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = getWheels();
        newWheelsList.add(newWheel);
        return new Car(getYear(), getColor(), newWheelsList, getEngine());
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
        return engine == null ? null : engine.clone();
    }

    private void fillList(List<Wheel> wheels) {
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel.getRadius()));
        }
    }

    private Engine initEngine(Engine engine) {
        if (engine != null) {
            return new Engine(engine.getHorsePower(), engine.getMaker());
        } else {
            return null;
        }
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
        return getYear() == car.getYear()
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }
}
