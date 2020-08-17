package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String maker;

    public Engine(int horsePower, String maker) {
        this.horsePower = horsePower;
        this.maker = maker;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getMaker() {
        return maker;
    }

    @Override
    public Engine clone() {
        return new Engine(horsePower, maker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == getClass()) {
            Engine engine = (Engine) o;
            return horsePower == engine.horsePower
                    && maker == engine.maker
                    || maker != null && maker.equals(engine.maker);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + horsePower;
        result = 31 * result + (maker != null ? maker.hashCode() : 0);
        return result;
    }
}
