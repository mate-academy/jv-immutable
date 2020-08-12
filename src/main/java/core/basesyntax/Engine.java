package core.basesyntax;

public class Engine implements Cloneable{
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
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Engine engine = (Engine) other;
        if (horsePower != engine.horsePower) return false;
        return maker != null ? maker.equals(engine.maker) : engine.maker == null;
    }

    @Override
    public int hashCode() {
        int result = horsePower;
        int prime = 41;
        result = prime * result + (maker != null ? maker.hashCode() : 0);
        return result;
    }
}
