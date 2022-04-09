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
        this.wheels = getCopyWheels(wheels);
        this.engine = engine != null ? engine.clone() : null ;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null ;
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

        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!Objects.equals(wheels, car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
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

    private List<Wheel> getCopyWheels(List<Wheel> wheelList){
        List<Wheel> copyWheels = new ArrayList<>(wheelList.size());
        for (Wheel wheel : wheelList) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }
}
