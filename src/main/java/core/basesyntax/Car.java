package core.basesyntax;

import java.util.Objects;

public class Car {
    private int year;
    private String color;
    private Wheel wheels;
    private Engine engine;

    public Car(int year, String color, Wheel wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.engine = engine;
    }

    public boolean equals(Car car) {
        if (this == car) {
            return true;
        }

        if (car == null || getClass() != car.getClass()) {
            return false;
        }

        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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
  