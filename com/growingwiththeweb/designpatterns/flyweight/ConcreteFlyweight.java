package com.growingwiththeweb.designpatterns.flyweight;

public class ConcreteFlyweight implements Flyweight<Integer> {
    private Integer intrinsicState;

    public ConcreteFlyweight(Integer intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void operation(Integer extrinsicState) {
        System.out.print("Intrinsic: " + intrinsicState + ", " +
                         "Extrinsic: " + extrinsicState);
    }
}
