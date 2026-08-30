package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final Integer year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(Integer year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : engine.clone();
        List<Wheel> tempList;
        tempList = new ArrayList<>();
        if (wheels != null) {
            if (wheels.size() != 0) {
                for (Wheel w : wheels) {
                    tempList.add(w.clone());
                }
            }
            this.wheels = Collections.unmodifiableList(tempList);
        } else {
            throw new NullPointerException();
        }
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        List<Wheel> tempList;
        tempList = new ArrayList<>();
        if (wheels != null) {
            for (Wheel w : wheels) {
                tempList.add(w.clone());
            }
        }
        return tempList;
    }

    public Engine getEngine() {
        if (engine != null) {
            return new Engine(engine.getHorsePower(),engine.getManufacturer());
        } else {
            return null;
        }
    }

    //переделать все что под этим сообщением

    @Override
    public int hashCode() {
        return Objects.hash(year,color,wheels,engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Ссылка на самого себя
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Проверка на null и тип
        }
        Car myClass = (Car) obj; // Приведение типа
        return Objects.equals(year, myClass.year) && Objects.equals(color, myClass.color)
                && Objects.equals(wheels, myClass.wheels)
                && Objects.equals(engine, myClass.engine); // Сравнение полей
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year,this.color,this.wheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year,newColor,this.wheels,this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> tempList;
        tempList = new ArrayList<>();
        for (Wheel w : wheels) {
            tempList.add(w.clone());
        }
        tempList.add(newWheel.clone());
        return new Car(this.year,this.color,tempList,this.engine);
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
