package core.basesyntax;

public final class Engine implements Cloneable {
    private static final String CloneError = "Failed to clone Engine";
    private int horsePower;
    private String manufacturer;

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

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String newManufacture) {
        this.manufacturer = newManufacture;
    }

    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(CloneError, e);
        }
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower="
                + horsePower
                + ", manufacturer='"
                + manufacturer
                + '\''
                + '}';
    }

    @Override
    public int hashCode() {
        return CloneError.hashCode()
                * Integer.valueOf(horsePower).hashCode()
                * manufacturer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Engine castedToEngine
                && (this == castedToEngine
                || (this.manufacturer.equals(castedToEngine.manufacturer)
                && this.horsePower == castedToEngine.horsePower));
    }
}
