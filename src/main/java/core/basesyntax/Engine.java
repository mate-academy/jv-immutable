package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable{
    private  int horsePower;
    private   String manufacturer;

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
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return getHorsePower() == engine.getHorsePower() && Objects.equals(getManufacturer(), engine.getManufacturer());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getHorsePower(), getManufacturer());
    }

    @Override
    public Engine clone()  {
        try{
            Engine engineCopy = (Engine) super.clone();
            return engineCopy;
        }catch(CloneNotSupportedException e){
          throw new RuntimeException("Can´t clone engine", e)  ;
        }
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
