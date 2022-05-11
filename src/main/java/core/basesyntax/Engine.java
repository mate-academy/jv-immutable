package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object engine) {
        if (this == engine) {
            return true;
        }
        if (!(engine instanceof Engine)) {
            return false;
        }
        if (engine.getClass().equals(Engine.class)) {
            Engine enginOther = (Engine) engine;
            boolean horsePowerEquals
                    = (horsePower == 0 && enginOther.horsePower == 0)
                    || (horsePower != 0 && enginOther.horsePower != 0
                    && horsePower == enginOther.horsePower);
            boolean manufacturerEquals
                    = (manufacturer == null && enginOther.manufacturer == null)
                    || (manufacturer != null && enginOther.manufacturer != null
                    && manufacturer.equals(enginOther.manufacturer));
            return horsePowerEquals && manufacturerEquals;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        if (horsePower != 0) {
            result = prime * result + horsePower;
        }
        if (manufacturer != null) {
            result = prime * result + manufacturer.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Engine ", e);
        }
    }

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
}
