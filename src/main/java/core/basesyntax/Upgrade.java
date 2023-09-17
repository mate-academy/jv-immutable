package core.basesyntax;

public interface Upgrade {
    Car changeEngine(Engine engine);

    Car changeColor(String newColor);

    Car addWheel(Wheel newWheel);
}
