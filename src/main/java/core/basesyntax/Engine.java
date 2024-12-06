package core.basesyntax;

public class Engine {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower , String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
