package core.basesyntax;

import java.util.List;

/**
 * Make this class immutable. See requirements in the README file
 */
public class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

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
