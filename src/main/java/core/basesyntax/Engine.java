public class Engine {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Engine withHorsePower(int newHorsePower) {
        return new Engine(newHorsePower, this.manufacturer);
    }

    public Engine withManufacturer(String newManufacturer) {
        return new Engine(this.horsePower, newManufacturer);
    }
}
