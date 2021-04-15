package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Wheel> testWheels = List.of(new Wheel(10), new Wheel(15), new Wheel(20));
        Engine testEngine = new Engine(100, "Some maker");
        Car testCar = new Car(1999, "red", testWheels, testEngine);

        Engine expected = new Engine(90, "new maker");

        testCar.changeEngine(expected);

        System.out.println(testCar);
    }
}
