package core.basesyntax;

public class Engine implements Cloneable{


    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private int horsePower;
    private String manufacturer;
    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    protected Engine clone()  {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            //TODO
        }
        return null;
    }

}
