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
        this.wheels = getCopy(wheels);
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public List<Wheel> getWheels() {
        return getCopy(this.wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(),getWheels(),engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(),newColor,getWheels(),getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = getCopy(wheels);
        wheelList.add(newWheel);
        return new Car(getYear(),getColor(),wheelList,getEngine());
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private static List<Wheel> getCopy(List<Wheel> list) {
        List<Wheel> copiedList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            copiedList.add(wheel.clone());
        }
        return copiedList;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
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

        if (year != car.year) {
            return false;
        }
        if (color != null ? !color.equals(car.color) : car.color != null) {
            return false;
        }
        if (wheels != null ? !wheels.equals(car.wheels) : car.wheels != null) {
            return false;
        }
        return engine != null ? engine.equals(car.engine) : car.engine == null;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}

