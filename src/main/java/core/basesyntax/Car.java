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
        this.wheels = getWheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public int getYear() {
        return year;
    }

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }

        return newWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        for (int i = 0; i < wheels.size(); i++) {
            if (!wheels.get(i).equals(((Car) o).getWheels().get(i))) {
                return false;
            }
        }

        return (color != null && color.equals(car.color))
                && (engine == car.engine || (engine != null && engine.equals(car.engine)))
                && (year == car.year);
    }

    @Override
    public int hashCode() {
        int result = 17;

        for (Wheel wheel : wheels) {
            result = 31 * result + wheel.hashCode();
        }
        result = 31 * result + year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);

        return result;
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
