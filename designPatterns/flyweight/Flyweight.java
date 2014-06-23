package designPatterns.flyweight;

public interface Flyweight<S> {
    public void operation(S extrinsicState);
}
