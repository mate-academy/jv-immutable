package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Wheel> testWheels = List.of(new Wheel(10), new Wheel(15), new Wheel(20));
        Engine testEngine = new Engine(100, "Some maker");
        Car testCar = new Car(1999, "red", testWheels, testEngine);
        Car actualCar = testCar.addWheel(new Wheel(90));
        int actualSizeDelta = actualCar.getWheels().size() - testCar.getWheels().size();

        System.out.println(actualSizeDelta);
    }
}
