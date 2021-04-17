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
        this.wheels = copyList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            Car current = (Car) obj;
            return (this.year == current.year
                    && Objects.equals(this.color, current.color)
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> copyList(List<Wheel> listToCopy) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : listToCopy) {
            list.add(wheel.clone());
        }
        return list;
    }
}
