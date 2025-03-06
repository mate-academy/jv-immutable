package core.basesyntax;

public class Engine {
    private int horsePower;
    private String manufacturer;
public Engine(int horsPower, String manufacturer) {
    this.horsePower = horsPower;
    this.manufacturer = manufacturer;
}
public Engine clone() {
    return new Engine(this.horsePower, this.manufacturer);
}
    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
