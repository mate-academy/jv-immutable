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
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        this.wheels = list;
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return new Car(year,color, list, engine);
    }

    public Car changeColor(String newColor) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return new Car(year,newColor, list, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        list.add(newWheel);
        return new Car(year, color, list, engine.clone());
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car != null && car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            if (this.wheels.size() != current.wheels.size()) {
                return false;
            }
            boolean listsOfWheelsEquals = true;
            for (int i = 0; i < this.wheels.size(); i++) {
                if (this.wheels.get(i) != null
                        && this.wheels.get(i).equals(current.wheels.get(i))) {
                    continue;
                }
                listsOfWheelsEquals = false;
            }
            return this.year == current.year
                    && this.color.equals(current.color)
                    && listsOfWheelsEquals
                    && this.engine.equals(current.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result + year;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        for (Wheel wheel : wheels) {
            result = 17 * result + (wheel == null ? 0 : wheel.hashCode());
        }
        result = 17 * result + (engine == null ? 0 : engine.hashCode());
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
