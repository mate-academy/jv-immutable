package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car  {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private  final Engine engine;
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = engine == null?null: engine.clone();
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public Engine getEngine() {

            return  engine == null?null: engine.clone();
    }
    public List<Wheel> getWheels() {return getCopy(wheels);}

    public  Car addWheel(Wheel newWheel) {
        if(newWheel == null){
            throw new NullPointerException();
        }
        ArrayList<Wheel> w = getCopy(wheels);
       w.add(newWheel);
        return new Car(year,color,w,engine);
    }
    private static ArrayList<Wheel> getCopy(List<Wheel> wheels){

    ArrayList<Wheel> wheelsCopy  = new ArrayList<>(wheels.size());
    for(Wheel wheel: wheels){
        wheelsCopy.add(wheel.clone());
    }
    return wheelsCopy;
}


    public Car changeEngine(Engine engine) {
        if (engine.getManufacturer() == null||engine.getHorsePower()==0){
          throw new NullPointerException();
        }
        return new Car(year,color,wheels,engine);
}
    public Car changeColor(String newColor){
        return new Car(year,newColor,wheels,engine);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor()) && Objects.equals(wheels, car.wheels) && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(),wheels, getEngine());
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
