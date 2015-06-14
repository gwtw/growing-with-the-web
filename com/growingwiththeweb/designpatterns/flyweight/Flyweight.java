package com.growingwiththeweb.designpatterns.flyweight;

public interface Flyweight<S> {
    public void operation(S extrinsicState);
}
