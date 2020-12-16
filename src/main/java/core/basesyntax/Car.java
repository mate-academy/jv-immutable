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
        this.wheels = new ArrayList<>(cloneWheel(wheels));
        this.engine = engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object thatCame) {
        if (this == thatCame) {
            return true;
        }
        if (thatCame == null || getClass() != thatCame.getClass()) {
            return false;
        }
        Car car = (Car) thatCame;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = new ArrayList<>(wheels);
        wheelList.add(newWheel);
        return new Car(this.year, this.color, wheelList, this.engine);
    }

    private List<Wheel> cloneWheel(List<Wheel> wheel) {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel currentWheel : wheel) {
            wheelList.add(currentWheel.clone());
        }
        return wheelList;
    }
}
