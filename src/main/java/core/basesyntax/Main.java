package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel(13));

        Engine engine = new Engine(300, "Germany");
        Car car = new Car(2024, "red", wheels, engine);
        System.out.println(car);
    }
}
