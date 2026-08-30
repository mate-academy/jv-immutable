package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.wheels = getWheelCopyList(wheels);
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create 'Car' clone", e);
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelCopyList(this.wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> arrayList = getWheelCopyList(wheels);
        arrayList.add(newWheel);
        return new Car(this.year, this.color, arrayList, this.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, engine, wheels, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Car car = (Car) obj;
        return Objects.equals(color, car.color) && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels) && year == car.year;
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color='" + color + '\'' + ", wheels=" + wheels + ","
                + " engine=" + engine + '}';
    }

    private List<Wheel> getWheelCopyList(List<Wheel> list) {
        List<Wheel> copiedList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            copiedList.add(wheel.clone());
        }
        return copiedList;
    }
}
