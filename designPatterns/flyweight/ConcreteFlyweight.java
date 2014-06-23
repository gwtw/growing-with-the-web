public class ConcreteFlyweight implements Flyweight {
    private int intrinsicState;

    public ConcreteFlyweight(int intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void operation(int extrinsicState) {
        System.out.print("Intrinsic: " + intrinsicState + ", " +
                         "Extrinsic: " + extrinsicState);
    }
}
