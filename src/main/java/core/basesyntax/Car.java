package core.basesyntax;

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
        this.wheels = getWheelListCopy(wheels);
        this.engine = getEngineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelListCopy(wheels);
    }

    public Engine getEngine() {
        return getEngineCopy(engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = getWheelListCopy(wheels);
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        return new Car(year, color, wheels, engine);
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
            return (year == car.year)
                    && ((color == car.color) || (color != null && color.equals(car.color)))
                    && ((wheels == car.wheels) || (checkListEqual(car.wheels)))
                    && ((engine == car.engine) || (engine != null
                    && engine.equals(car.engine)));
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

    private List<Wheel> getWheelListCopy(List<Wheel> wheels) {
        return wheels.stream().map(Wheel::clone).collect(Collectors.toList());
    }

    private Engine getEngineCopy(Engine engine) {
        return engine != null ? engine.clone() : null;
    }
}
