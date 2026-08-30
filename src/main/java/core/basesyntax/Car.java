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
        this.color = color == null ? null : new String(color);
        this.wheels = getNewWheels(wheels);
        this.engine = engine == null ? null : (Engine) engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getNewWheels(wheels);
        newWheels.add((Wheel) newWheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return new String(color);
    }

    public List<Wheel> getWheels() {
        return getNewWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : (Engine) engine.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        Car objCar = (Car) obj;
        return objCar != null
                && this.getClass() == objCar.getClass()
                && this.engine.equals(objCar.engine)
                && this.color.equals(objCar.color)
                && this.wheels.equals(objCar.wheels)
                && this.year == objCar.year;
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

    private List<Wheel> getNewWheels(List<Wheel> oldWheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : oldWheels) {
            newWheels.add((Wheel) wheel.clone());
        }
        return newWheels;
    }
}
