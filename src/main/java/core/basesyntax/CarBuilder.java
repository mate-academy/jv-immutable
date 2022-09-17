package core.basesyntax;

import java.util.List;

public class CarBuilder {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    public CarBuilder setYear(final int year) {
        this.year = year;
        return this;
    }

    public CarBuilder setColor(final String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setWheels(final List<Wheel> wheels) {
        this.wheels = wheels;
        return this;
    }

    public CarBuilder setEngine(final Engine engine) {
        this.engine = engine;
        return this;
    }

    public Car build() {
        return new Car(year,color,wheels,engine);
    }
}
