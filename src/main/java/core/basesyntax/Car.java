package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {

    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel w : wheels) {
            wheelList.add((Wheel) w.clone());
        }
        this.wheels = wheelList;
        this.year = year;
        this.color = color;
        if (engine != null) {
            this.engine = (Engine) engine.clone();
        } else {
            this.engine = null;
        }

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

    public List<Wheel> getWheels() {
        ArrayList<Wheel> wheels = new ArrayList();
        for (Wheel w : this.wheels) {
            wheels.add(w.clone());
        }
        return wheels;
    }

    public Engine getEngine() {
        return engine != null ? (Engine)engine.clone() : null;
    }

    public Car changeEngine(Engine e) {
        List<Wheel> wheel = new ArrayList();
        for (Wheel w : this.wheels) {
            wheel.add((Wheel) w.clone());
        }
        return new Car(this.year, this.color, wheel, (Engine) e.clone());
    }

    public Car changeColor(String color) {
        List<Wheel> wheel = new ArrayList();
        for (Wheel w : this.wheels) {
            wheel.add((Wheel) w.clone());
        }
        return new Car(this.year, color, wheel, (Engine) this.engine.clone());
    }

    public Car addWheel(Wheel wh) {
        List<Wheel> wheel = new ArrayList();
        for (Wheel w : this.wheels) {
            wheel.add((Wheel) w.clone());
        }
        wheel.add(wh);
        return new Car(this.year, color, wheel, this.engine.clone());
    }

    @Override
    public int hashCode() {
        int hashCode = 11;
        hashCode = hashCode * 17 + year;
        hashCode = hashCode * 17 + color.hashCode();
        hashCode = hashCode * 17 + wheels.hashCode();
        hashCode = hashCode * 17 + engine.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(Car.class)) {
            return false;
        }
        Car current = (Car)obj;
        boolean colorEquals = current.color == this.color || this.color != null
                && this.color.equals(current.color);
        boolean wheelsEquals = current.wheels == this.wheels || this.wheels != null
                && this.wheels.equals(current.wheels);
        boolean engineEquals = current.engine == this.engine || this.engine != null
                && this.engine.equals(current.engine);
        return this.year == current.year && colorEquals && wheelsEquals
                && engineEquals;
    }
}
