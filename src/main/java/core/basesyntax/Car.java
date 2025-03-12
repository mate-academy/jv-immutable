package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        // Робимо захисну копію вхідного списку
        this.wheels = new ArrayList<>(wheels);
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // Повертаємо незмінний список, щоб зовнішній код не зміг змінити внутрішній стан
    public List<Wheel> getWheels() {
        return Collections.unmodifiableList(wheels);
    }

    // Engine сам по собі незмінний, тому без клонування
    public Engine getEngine() {
        return engine;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Car{");
        sb.append("year=").append(year)
                .append(", color='").append(color).append('\'')
                .append(", wheels=").append(wheels)
                .append(", engine=").append(engine)
                .append('}');
        return sb.toString();
    }
}
