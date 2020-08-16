package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels.stream().map(Wheel::clone).collect(Collectors.toList());
        this.engine = engine != null ? new Engine(engine.getHorsePower(), engine.getMaker()) : null;
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

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel www : wheels) {
            newList.add(www.clone());
        }
        newList.add(newWheel);
        return new Car(year, color, newList, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, new ArrayList<>(wheels), engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    @Override
    protected Car clone() {
        return new Car(year, color, wheels, engine.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == getClass()) {
            Car car = (Car) o;
            return year == car.getYear() && color == car.getColor()
                    || color != null && color.equals(car.getColor())
                    && wheels == car.getWheels() || checkListEqual(car.getWheels())
                    && engine == car.getEngine() || engine != null
                    && engine.equals(car.getEngine());
        }
        return false;
    }

    private boolean checkListEqual(List<Wheel> list) {
        if (list.size() != wheels.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!wheels.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? hashCodeList() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    private int hashCodeList() {
        int hash = 0;
        for (Wheel wheel : wheels) {
            hash += (wheel != null ? wheel.hashCode() : 0);
        }
        return hash;
    }
}
