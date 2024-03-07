package core.basesyntax;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
