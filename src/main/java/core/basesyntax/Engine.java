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

    public String getMaker() {
        return maker;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    protected Engine clone() {
        return new Engine(horsePower, maker);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower
                && Objects.equals(maker, engine.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, maker);
    }
}
