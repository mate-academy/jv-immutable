package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private Integer radius;

    public Wheel(Integer radius) {
        this.radius = radius;
    }

    public int getRadius() {
        Wheel newWheel = new Wheel(this.radius);
        return newWheel.radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Ссылка на самого себя
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Проверка на null и тип
        }
        Wheel myClass = (Wheel) obj; // Приведение типа
        return Objects.equals(radius,myClass.radius);
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}
