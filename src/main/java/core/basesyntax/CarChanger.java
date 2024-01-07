package core.basesyntax;

public interface CarChanger {
    Car changeEngine(Engine engine);

    Car changeColor(String newColor);

    Car addWheel(Wheel newWheel);
}
