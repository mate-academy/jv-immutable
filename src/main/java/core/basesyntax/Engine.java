package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;
    
    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
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
    
    @Override
    protected Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone object");
        }
    }
    
    @Override
    public String toString() {
        return "Engine{"
                + "horsePower=" + horsePower
                + ", manufacturer='" + manufacturer + '\''
                + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engine)) {
            return false;
        }
        
        Engine engine = (Engine) o;
        
        if (getHorsePower() != engine.getHorsePower()) {
            return false;
        }
        return getManufacturer().equals(engine.getManufacturer());
    }
    
    @Override
    public int hashCode() {
        int result = getHorsePower();
        result = 31 * result + getManufacturer().hashCode();
        return result;
    }
}
