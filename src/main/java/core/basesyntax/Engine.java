package core.basesyntax;

public class Engine {
    private int horsePower;
    private String manufacturer;

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }
}
