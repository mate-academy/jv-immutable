package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String maker;

    public Engine(int horsePower, String maker) {
        this.horsePower = horsePower;
        this.maker = maker;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, maker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return getHorsePower() == engine.getHorsePower() &&
                Objects.equals(getMaker(), engine.getMaker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorsePower(), getMaker());
    }
}
