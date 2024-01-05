package core.basesyntax;

import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    /**
     * Implement this class.
     */
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        if (engine != null) {
            this.engine = engine.clone();
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
}
