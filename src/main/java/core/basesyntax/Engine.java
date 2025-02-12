package core.basesyntax;

public final class Engine {
    private final int horsePower;
    private final String manufacturer;

    //implement this class
    public Engine(int horsePower, String manufacturer) {
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

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, manufacturer);
    }
}
